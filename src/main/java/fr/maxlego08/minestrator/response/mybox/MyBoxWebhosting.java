package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxWebhosting(
        long id,
        String offer,
        String domain,
        String hashsupport,
        int status
) {
}
