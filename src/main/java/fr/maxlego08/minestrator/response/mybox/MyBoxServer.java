package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxServer(
        long id,
        String name,
        String hashsupport,
        int egg,
        String egg_icon,
        String egg_name,
        String ip,
        int dedicated_ip,
        int cpu,
        int ram,
        int disabled,
        int is_expired,
        int is_suspended,
        String location,
        String country,
        String country_iso
) {
}
