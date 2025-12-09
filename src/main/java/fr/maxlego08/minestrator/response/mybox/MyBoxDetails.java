package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxDetails(
        long id,
        String hashsupport,
        String name,
        String tstart,
        String tend,
        int is_trial,
        int is_free,
        int optimizable,
        int owner,
        MyBoxPermissions perms,
        int is_expired,
        int is_suspended,
        int is_pro,
        int has_bonus,
        int tend_days,
        int promotion_recurrent,
        int promotion_reduction,
        int subscription,
        int cpu_remaining,
        int ram_remaining
) {
}
