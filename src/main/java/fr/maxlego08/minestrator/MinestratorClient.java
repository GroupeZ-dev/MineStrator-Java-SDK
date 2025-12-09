package fr.maxlego08.minestrator;

import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.response.MinestratorResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class MinestratorClient {

    private final String baseUrl;
    private final String apiKey;
    private final HttpClient httpClient;

    public MinestratorClient(String apiKey) {
        this("https://mine.sttr.io", apiKey);
    }

    public MinestratorClient(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofSeconds(30)).build();
    }

    public <T> MinestratorResponse<T> send(MinestratorRequest<T> request) throws IOException, InterruptedException {
        HttpRequest httpRequest = buildHttpRequest(request);
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        return JsonMapper.mapper().readValue(response.body(), request.responseType());
    }

    public <T> CompletableFuture<MinestratorResponse<T>> sendAsync(MinestratorRequest<T> request) {
        HttpRequest httpRequest = buildHttpRequest(request);
        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).thenApply(resp -> {
            try {
                return JsonMapper.mapper().readValue(resp.body(), request.responseType());
            } catch (IOException e) {
                throw new RuntimeException("Erreur de parsing JSON", e);
            }
        });
    }

    private <T> HttpRequest buildHttpRequest(MinestratorRequest<T> request) {
        Endpoint endpoint = request.endpoint();
        String path = resolvePath(endpoint.pathTemplate(), request.pathParams());
        URI uri = URI.create(baseUrl + path);

        HttpRequest.Builder builder = HttpRequest.newBuilder().uri(uri).timeout(Duration.ofSeconds(30)).header("Accept", "application/json");

        if (endpoint.requiresBearer() && apiKey != null && !apiKey.isEmpty()) {
            String encoded = Base64.getEncoder().encodeToString(apiKey.getBytes(StandardCharsets.UTF_8));
            builder.header("Authorization", "Bearer " + encoded);
        }

        String jsonBody = null;
        if (endpoint.hasPayload() && request.body() != null) {
            jsonBody = JsonMapper.toJson(request.body());
            builder.header("Content-Type", "application/json");
        }

        HttpRequest.BodyPublisher publisher = jsonBody == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8);

        builder.method(endpoint.method().name(), publisher);

        return builder.build();
    }

    private String resolvePath(String template, Map<String, String> pathParams) {
        if (pathParams == null || pathParams.isEmpty()) return template;
        String result = template;
        for (var entry : pathParams.entrySet()) {
            String key = "{" + entry.getKey() + "}";
            String value = URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8);
            result = result.replace(key, value);
        }
        return result;
    }
}
