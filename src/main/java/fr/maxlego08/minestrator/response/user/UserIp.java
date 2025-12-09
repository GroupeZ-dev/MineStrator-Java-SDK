package fr.maxlego08.minestrator.response.user;

public record UserIp(
        IpInfo actual,
        IpInfo last,
        IpInfo register
) {
}
