package fr.maxlego08.minestrator.response.server.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LiveStats(
        String state,
        CpuStats cpu,
        MemoryStats memory,
        DiskStats disk,
        NetworkStats network,
        UptimeStats uptime,
        PlayersStats players,
        String version,
        String hostname
) {
}
