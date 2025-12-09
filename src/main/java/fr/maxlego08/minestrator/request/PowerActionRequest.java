package fr.maxlego08.minestrator.request;

import com.fasterxml.jackson.core.type.TypeReference;
import fr.maxlego08.minestrator.MinestratorRequest;
import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.api.PowerAction;
import fr.maxlego08.minestrator.model.PowerActionRequestBody;
import fr.maxlego08.minestrator.response.MinestratorResponse;

import java.util.Map;

public class PowerActionRequest implements MinestratorRequest<Void> {

    private final String serverId;
    private final PowerAction action;

    public PowerActionRequest(String serverId, PowerAction action) {
        this.serverId = serverId;
        this.action = action;
    }

    @Override
    public Endpoint endpoint() {
        return Endpoint.SERVER_POWER_ACTION;
    }

    @Override
    public Map<String, String> pathParams() {
        return Map.of("serverId", serverId);
    }

    @Override
    public Object body() {
        return new PowerActionRequestBody(action);
    }

    @Override
    public TypeReference<MinestratorResponse<Void>> responseType() {
        return new TypeReference<>() {
        };
    }
}
