package fr.maxlego08.minestrator.response.server.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OfferInfo(
        String name,
        int is_pro,
        int is_trial,
        int is_free,
        int cpu,
        int ram,
        int disk
) {
}
