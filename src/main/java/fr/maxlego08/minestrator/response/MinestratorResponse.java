package fr.maxlego08.minestrator.response;

/**
 * Racine JSON globale : { "api": { ... } }
 */
public record MinestratorResponse<T>(
        ApiContent<T> api
) {
}
