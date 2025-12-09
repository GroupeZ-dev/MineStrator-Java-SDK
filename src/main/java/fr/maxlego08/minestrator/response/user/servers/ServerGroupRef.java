package fr.maxlego08.minestrator.response.user.servers;

import java.util.List;

public record ServerGroupRef(
        long id_server,
        List<String> permissions
) {
}
