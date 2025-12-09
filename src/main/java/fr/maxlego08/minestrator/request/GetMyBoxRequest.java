package fr.maxlego08.minestrator.request;

import com.fasterxml.jackson.core.type.TypeReference;
import fr.maxlego08.minestrator.MinestratorRequest;
import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.response.MinestratorResponse;
import fr.maxlego08.minestrator.response.mybox.MyBoxData;

import java.util.Map;

/**
 * GET /mybox/{myboxId}
 */
public class GetMyBoxRequest implements MinestratorRequest<MyBoxData> {

    private final String myboxId;

    public GetMyBoxRequest(String myboxId) {
        this.myboxId = myboxId;
    }

    @Override
    public Endpoint endpoint() {
        return Endpoint.GET_MYBOX;
    }

    @Override
    public Map<String, String> pathParams() {
        return Map.of("myboxId", myboxId);
    }

    @Override
    public Object body() {
        return null;
    }

    @Override
    public TypeReference<MinestratorResponse<MyBoxData>> responseType() {
        return new TypeReference<>() {
        };
    }
}
