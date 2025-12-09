package fr.maxlego08.minestrator.response.user.servers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserServersData(
        Map<String, ServerGroup> servers_groups,
        List<UserServer> servers
) {
}
