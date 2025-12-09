package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxDedicatedIp(
        String ip,
        long id_server,
        String price,
        String note
) {
}
