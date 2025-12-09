package fr.maxlego08.minestrator;

import com.fasterxml.jackson.core.type.TypeReference;
import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.response.MinestratorResponse;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface MinestratorRequest<T> {

    Endpoint endpoint();

    Map<String, String> pathParams();

    Object body();

    TypeReference<MinestratorResponse<T>> responseType();

    // Version synchrone
    default MinestratorResponse<T> send() {
        try {
            return Minestrator.client().send(this);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'appel MineStrator", e);
        }
    }

    // Version asynchrone
    default CompletableFuture<MinestratorResponse<T>> sendAsync() {
        return Minestrator.client().sendAsync(this);
    }
}
