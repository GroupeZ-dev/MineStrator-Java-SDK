package fr.maxlego08.minestrator.response.user.servers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserServer(
        long id,
        String hashsupport,
        long id_mybox,
        long id_daemon,
        String tstart,
        String tend,
        String ip,
        int port,
        String dns,
        int is_free,
        int id_groupe,
        String note,
        int id_egg,
        int is_disabled,
        String name,
        int owner,
        int is_bedrock,
        String egg_uuid,
        String egg_name,
        String egg_icon,
        int is_expired,
        int is_suspended,
        int reduction,
        String last_backup,
        String poweraction_message_restart,
        String poweraction_message_stop
) {
}
