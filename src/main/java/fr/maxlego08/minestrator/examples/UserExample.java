package fr.maxlego08.minestrator.examples;

import fr.maxlego08.minestrator.Minestrator;
import fr.maxlego08.minestrator.request.GetUserRequest;
import fr.maxlego08.minestrator.response.MinestratorResponse;
import fr.maxlego08.minestrator.response.user.UserData;

public class UserExample {

    public static void main(String[] args) {

        Minestrator.configure("YOUR_API_KEY");

        GetUserRequest request = new GetUserRequest();
        MinestratorResponse<UserData> response = request.send();
        var user = response.api().data().user();

        System.out.println("Pseudo : " + user.datas().pseudo());
        System.out.println("Mail   : " + user.datas().mail());
        System.out.println("Money  : " + user.datas().money());
    }
}
