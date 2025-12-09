package fr.maxlego08.minestrator;

public final class Minestrator {

    private static MinestratorClient CLIENT;

    private Minestrator() {}

    public static void configure(String apiKey) {
        CLIENT = new MinestratorClient(apiKey);
    }

    public static void configure(MinestratorClient client) {
        CLIENT = client;
    }

    public static MinestratorClient client() {
        if (CLIENT == null) {
            throw new IllegalStateException("Minestrator n'est pas configuré. Appelle Minestrator.configure(apiKey) au démarrage.");
        }
        return CLIENT;
    }
}
