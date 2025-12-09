package fr.maxlego08.minestrator.response.server.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CpuStats(
        Double current,
        Integer dedicated,
        Integer flexcore,
        Integer limit,
        Integer percent,
        Boolean is_bursting
) {
}
