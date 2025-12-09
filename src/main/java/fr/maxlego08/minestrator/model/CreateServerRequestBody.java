package fr.maxlego08.minestrator.model;

import java.util.List;

/**
 * Body JSON pour la création de serveur.
 */
public record CreateServerRequestBody(
        int id_egg,
        int cpu,
        int ram,
        String name,
        List<RequiredField> required_fields
) {
}
