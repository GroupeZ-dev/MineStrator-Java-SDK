package fr.maxlego08.minestrator.response.server.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HistoryEntry(
        String date,
        String ip,
        String action
) {
}
