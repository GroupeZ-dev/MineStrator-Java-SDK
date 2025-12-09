package fr.maxlego08.minestrator.response.server.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ServerSettings(
        PoweractionMessage poweraction_message,
        int is_bedrock,
        int is_bungeecord,
        int java_memory,
        String image,
        int id_java_version,
        String startup,
        String startup_file
) {
}
