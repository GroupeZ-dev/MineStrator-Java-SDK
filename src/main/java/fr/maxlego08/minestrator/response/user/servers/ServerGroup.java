package fr.maxlego08.minestrator.response.user.servers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ServerGroup(
        long id,
        int owner,
        String owner_name,
        String name,
        String hashsupport,
        int order,
        int mybox,
        String tend,
        String offer,
        String note,
        int is_free,
        int is_pro,
        int is_expired,
        int is_suspended,
        Integer promo_recurrent,
        Integer promo_reduction,
        GroupResources resources,
        List<String> permissions,
        List<ServerGroupRef> servers,
        List<Object> webhosting
) {
}
