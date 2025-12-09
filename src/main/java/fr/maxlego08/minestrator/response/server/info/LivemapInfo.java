package fr.maxlego08.minestrator.response.server.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivemapInfo(
        int option,
        int enabled,
        int is_free
) {
}
