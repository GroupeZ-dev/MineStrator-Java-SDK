package fr.maxlego08.minestrator.request;

import com.fasterxml.jackson.core.type.TypeReference;
import fr.maxlego08.minestrator.MinestratorRequest;
import fr.maxlego08.minestrator.api.Endpoint;
import fr.maxlego08.minestrator.model.CreateServerRequestBody;
import fr.maxlego08.minestrator.model.RequiredField;
import fr.maxlego08.minestrator.response.CreateServerData;
import fr.maxlego08.minestrator.response.MinestratorResponse;

import java.util.List;
import java.util.Map;

public class CreateServerRequest implements MinestratorRequest<CreateServerData> {

    private final int idEgg;
    private final int cpu;
    private final int ram;
    private final String name;
    private final List<RequiredField> requiredFields;
    private final String myboxId;

    public CreateServerRequest(int idEgg, int cpu, int ram, String name, List<RequiredField> requiredFields, String myboxId) {
        this.idEgg = idEgg;
        this.cpu = cpu;
        this.ram = ram;
        this.name = name;
        this.requiredFields = requiredFields;
        this.myboxId = myboxId;
    }

    @Override
    public Endpoint endpoint() {
        return Endpoint.CREATE_SERVER_ON_MYBOX;
    }

    @Override
    public Map<String, String> pathParams() {
        return Map.of("myboxId", myboxId);
    }

    @Override
    public Object body() {
        return new CreateServerRequestBody(idEgg, cpu, ram, name, requiredFields);
    }

    @Override
    public TypeReference<MinestratorResponse<CreateServerData>> responseType() {
        return new TypeReference<>() {
        };
    }
}
