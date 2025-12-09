package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxOption(
        String identifier,
        String offer,
        String price,
        int is_free
) {
}
