package fr.maxlego08.minestrator.api;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PowerAction {
    START("start"),
    STOP("stop"),
    RESTART("restart"),
    KILL("kill");

    private final String value;

    PowerAction(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
