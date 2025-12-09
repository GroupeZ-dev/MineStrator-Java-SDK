package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxDatabase(
        long id,
        String host,
        int port,
        String dbname,
        String username,
        String password,
        String description
) {
}
