package fr.maxlego08.minestrator.response;

/**
 * Data retournée lors de la création d'un serveur.
 */
public record CreateServerData(
        int id_mybox,
        String id_server,
        String ip
) {
}
