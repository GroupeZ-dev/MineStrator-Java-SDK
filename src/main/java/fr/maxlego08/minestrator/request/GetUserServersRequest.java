package fr.maxlego08.minestrator.request;

import com.fasterxml.jackson.core.type.TypeReference;
import fr.maxlego08.minestrator.MinestratorRequest;
import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.response.MinestratorResponse;
import fr.maxlego08.minestrator.response.user.servers.UserServersData;

import java.util.Map;

public class GetUserServersRequest implements MinestratorRequest<UserServersData> {

    private final String userId;

    public GetUserServersRequest(String userId) {
        this.userId = userId;
    }

    @Override
    public Endpoint endpoint() {
        return Endpoint.GET_USER_SERVERS;
    }

    @Override
    public Map<String, String> pathParams() {
        return Map.of("userId", userId);
    }

    @Override
    public Object body() {
        return null;
    }

    @Override
    public TypeReference<MinestratorResponse<UserServersData>> responseType() {
        return new TypeReference<>() {
        };
    }
}
