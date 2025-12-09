package fr.maxlego08.minestrator.response.server.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DiskStats(
        Integer current,
        Integer limit,
        Integer percent
) {
}
