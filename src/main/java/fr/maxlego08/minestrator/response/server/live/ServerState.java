package fr.maxlego08.minestrator.response.server.live;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServerState {
    STARTING,
    ONLINE,
    OFFLINE;

    @JsonCreator
    public static ServerState fromString(String value) {
        return value == null ? null : ServerState.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return name().toLowerCase();
    }
}

