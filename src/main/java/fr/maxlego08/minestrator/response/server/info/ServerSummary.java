package fr.maxlego08.minestrator.response.server.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ServerSummary(
        long id,
        String hashsupport,
        long id_mybox,
        long id_daemon,
        String tstart,
        String tend,
        String ip,
        int port,
        String dns,
        int is_free,
        int id_groupe,
        int ordre,
        String name,
        String uuid,
        int dedicated_ip,
        int owner        ,
        List<String> permissions
) {
}
