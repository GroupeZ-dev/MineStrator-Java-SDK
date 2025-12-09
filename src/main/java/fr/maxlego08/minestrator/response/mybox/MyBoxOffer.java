package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxOffer(
        int id,
        String name,
        double price,
        int cpu,
        int flexcpu,
        int flexcore,
        int ram,
        int disk,
        int dbsize,
        int dbnb,
        int pods
) {
}
