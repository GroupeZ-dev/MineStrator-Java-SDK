package fr.maxlego08.minestrator.examples;

import fr.maxlego08.minestrator.Minestrator;
import fr.maxlego08.minestrator.model.RequiredField;
import fr.maxlego08.minestrator.request.CreateServerRequest;
import fr.maxlego08.minestrator.response.CreateServerData;
import fr.maxlego08.minestrator.response.MinestratorResponse;

import java.util.List;

public class CreateExample {

    public static void main(String[] args) {
        Minestrator.configure("API_KEY_HERE");

        CreateServerRequest request = new CreateServerRequest(
                3358, // Custom Egg ID
                1, // CPU
                2, // RAM
                "ZIP Deploy Java 21",
                List.of(new RequiredField("ZIP_URL", "http://dl.minecraft.com/test/server.zip")),
                "MYBOX_ID" // id MyBox Pro
        );

        // Sync
        MinestratorResponse<CreateServerData> response = request.send();
        System.out.println("Code : " + response.api().code());
        System.out.println("Server ID : " + response.api().data().id_server());
        System.out.println("IP : " + response.api().data().ip());

        // Async
        request.sendAsync().thenAccept(resp -> {
            System.out.println("[ASYNC] Code : " + resp.api().code());
        });
    }
}
