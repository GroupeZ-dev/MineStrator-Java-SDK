package fr.maxlego08.minestrator.response.server.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ServerInfoData(
        WebsocketInfo websocket,
        List<Object> options,
        MyboxInfo mybox,
        OfferInfo offer,
        EggInfo egg,
        ServerSettings settings,
        List<HistoryEntry> history,
        List<PortInfo> ports,
        SftpInfo sftp,
        LivemapInfo livemap,
        ServerSummary server
) {
}
