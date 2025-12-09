package fr.maxlego08.minestrator.request;

import com.fasterxml.jackson.core.type.TypeReference;
import fr.maxlego08.minestrator.MinestratorRequest;
import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.response.MinestratorResponse;
import fr.maxlego08.minestrator.response.server.live.ServerLiveData;

import java.util.Map;

public class GetServerLiveRequest implements MinestratorRequest<ServerLiveData> {

    private final String serverId;

    public GetServerLiveRequest(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public Endpoint endpoint() {
        return Endpoint.GET_SERVER_LIVE;
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
    public TypeReference<MinestratorResponse<ServerLiveData>> responseType() {
        return new TypeReference<>() {
        };
    }
}
