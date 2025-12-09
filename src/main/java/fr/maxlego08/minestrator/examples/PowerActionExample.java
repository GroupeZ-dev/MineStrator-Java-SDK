package fr.maxlego08.minestrator.examples;


import fr.maxlego08.minestrator.Minestrator;
import fr.maxlego08.minestrator.api.PowerAction;
import fr.maxlego08.minestrator.request.PowerActionRequest;
import fr.maxlego08.minestrator.response.MinestratorResponse;

public class PowerActionExample {

    public static void main(String[] args) {

        Minestrator.configure("API_KEY_HERE");

        PowerActionRequest request = new PowerActionRequest("SERVER_ID", PowerAction.START);

        MinestratorResponse<Void> response = request.send();
        System.out.println("Code : " + response.api().code());
        System.out.println("Description : " + response.api().description());
    }
}
