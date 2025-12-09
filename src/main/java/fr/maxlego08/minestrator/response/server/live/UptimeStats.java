package fr.maxlego08.minestrator.response.server.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UptimeStats(
        Integer days,
        Integer hours,
        Integer minutes,
        Long total_seconds
) {
}
