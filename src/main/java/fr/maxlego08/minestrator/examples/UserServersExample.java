package fr.maxlego08.minestrator.examples;

import fr.maxlego08.minestrator.Minestrator;
import fr.maxlego08.minestrator.request.GetUserServersRequest;
import fr.maxlego08.minestrator.response.MinestratorResponse;
import fr.maxlego08.minestrator.response.user.servers.UserServersData;

public class UserServersExample {

    public static void main(String[] args) {

        Minestrator.configure("API_KEY_HERE");

        GetUserServersRequest request = new GetUserServersRequest("305502");
        MinestratorResponse<UserServersData> response = request.send();

        if (response.api().isError()) {
            System.out.println("Error !");
            return;
        }

        UserServersData data = response.api().data();

        System.out.println("Groups: " + data.servers_groups().size());
        System.out.println("Total servers: " + data.servers().size());

        data.servers().forEach(server -> {
            System.out.println(" - " + server.name() + " (" + server.ip() + ":" + server.port() + ")");
        });
    }
}
