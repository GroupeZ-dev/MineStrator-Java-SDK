package fr.maxlego08.minestrator.response.user;

public record UserNotification(
        long id,
        String type,
        String color,
        String icon,
        String message,
        String date,
        int viewed,
        int readed
) {
}
