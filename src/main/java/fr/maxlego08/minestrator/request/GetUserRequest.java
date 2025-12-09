package fr.maxlego08.minestrator.request;

import com.fasterxml.jackson.core.type.TypeReference;
import fr.maxlego08.minestrator.MinestratorRequest;
import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.response.MinestratorResponse;
import fr.maxlego08.minestrator.response.user.UserData;

import java.util.Map;

public class GetUserRequest implements MinestratorRequest<UserData> {

    @Override
    public Endpoint endpoint() {
        return Endpoint.GET_USER;
    }

    @Override
    public Map<String, String> pathParams() {
        return Map.of();
    }

    @Override
    public Object body() {
        return null;
    }

    @Override
    public TypeReference<MinestratorResponse<UserData>> responseType() {
        return new TypeReference<>() {
        };
    }
}
