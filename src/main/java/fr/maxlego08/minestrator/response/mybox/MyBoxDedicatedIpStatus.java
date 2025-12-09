package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxDedicatedIpStatus(
        int available,
        int is_free
) {
}
