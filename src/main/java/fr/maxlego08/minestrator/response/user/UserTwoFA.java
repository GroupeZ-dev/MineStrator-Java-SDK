package fr.maxlego08.minestrator.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserTwoFA(
        Integer enabled,
        String secret,
        String src
) {
}