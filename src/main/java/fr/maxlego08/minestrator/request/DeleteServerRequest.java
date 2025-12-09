package fr.maxlego08.minestrator.request;

import com.fasterxml.jackson.core.type.TypeReference;
import fr.maxlego08.minestrator.MinestratorRequest;
import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.response.MinestratorResponse;

import java.util.Map;

public class DeleteServerRequest implements MinestratorRequest<Void> {

    private final String myboxId;
    private final String serverId;

    public DeleteServerRequest(String myboxId, String serverId) {
        this.myboxId = myboxId;
        this.serverId = serverId;
    }

    @Override
    public Endpoint endpoint() {
        return Endpoint.DELETE_SERVER_ON_MYBOX;
    }

    @Override
    public Map<String, String> pathParams() {
        return Map.of("myboxId", myboxId, "serverId", serverId);
    }

    @Override
    public Object body() {
        return null; // DELETE sans body
    }

    @Override
    public TypeReference<MinestratorResponse<Void>> responseType() {
        return new TypeReference<>() {
        };
    }
}
