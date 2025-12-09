package fr.maxlego08.minestrator.request;

import com.fasterxml.jackson.core.type.TypeReference;
import fr.maxlego08.minestrator.MinestratorRequest;
import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.response.MinestratorResponse;
import fr.maxlego08.minestrator.response.server.info.ServerInfoData;

import java.util.Map;

public class GetServerInfoRequest implements MinestratorRequest<ServerInfoData> {

    private final String serverId;

    public GetServerInfoRequest(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public Endpoint endpoint() {
        return Endpoint.GET_SERVER_INFO;
    }

    @Override
    public Map<String, String> pathParams() {
        return Map.of("serverId", serverId);
    }

    @Override
    public Object body() {
        return null;
    }

    @Override
    public TypeReference<MinestratorResponse<ServerInfoData>> responseType() {
        return new TypeReference<>() {
        };
    }
}