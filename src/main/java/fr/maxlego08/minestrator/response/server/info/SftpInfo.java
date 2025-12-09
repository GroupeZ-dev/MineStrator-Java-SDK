package fr.maxlego08.minestrator.response.server.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SftpInfo(
        String protocol,
        String host,
        int port,
        String user,
        String password
) {
}
