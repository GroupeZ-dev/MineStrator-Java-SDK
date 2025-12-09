package fr.maxlego08.minestrator.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDatas(
        int id,
        String pseudo,
        String mail,
        int partner,
        int money,
        @JsonProperty("2fa") Integer twoFA,
        @JsonProperty("2fasecret") String twoFASecret,
        int blackmod,
        String lang,
        Object settings,
        String register_date,
        Integer promotional,
        Integer mail_validated,
        Integer wheel_fortune_tokens
) {
}