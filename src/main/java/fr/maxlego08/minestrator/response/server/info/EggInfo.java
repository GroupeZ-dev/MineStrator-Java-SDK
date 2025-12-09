package fr.maxlego08.minestrator.response.server.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EggInfo(
        int id,
        int type,
        String name,
        String icon,
        String uuid
) {
}
