package fr.maxlego08.minestrator.response.server.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyboxInfo(
        String name,
        String hashsupport,
        MyboxResources resources,
        int to_review
) {
}
