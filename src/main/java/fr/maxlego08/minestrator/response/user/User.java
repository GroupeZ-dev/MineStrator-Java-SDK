package fr.maxlego08.minestrator.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User(
        UserDatas datas,
        String api_authkey,
        UserIp ip,
        @JsonProperty("2fa") UserTwoFA twoFA,
        UserPayment payment,
        List<UserNotification> notifications,
        List<Object> alerts,
        Integer support_alert,
        Integer partnership_alert,
        String next_daily_drop,
        LinkedAccount linked_account,
        String global_message,
        String global_message_link,
        String global_message_icon,
        String global_message_color_bg,
        String global_message_color_text
) {
}
