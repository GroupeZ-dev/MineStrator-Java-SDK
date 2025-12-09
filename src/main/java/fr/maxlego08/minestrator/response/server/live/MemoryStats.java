package fr.maxlego08.minestrator.response.server.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MemoryStats(
        Integer current,
        Integer limit,
        Integer percent
) {
}
