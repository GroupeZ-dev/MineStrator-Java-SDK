package fr.maxlego08.minestrator.response.user;

public record LinkedAccount(
        MinecraftAccount minecraft,
        DiscordAccount discord
) {
}
