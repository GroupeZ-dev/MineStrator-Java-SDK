package fr.maxlego08.minestrator.response.server.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlayersStats(
        Integer current,
        Integer limit,
        List<Object> list
) {
}
