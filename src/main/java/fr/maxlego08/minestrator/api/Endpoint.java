package fr.maxlego08.minestrator.api;

public enum Endpoint {

    CREATE_SERVER_ON_MYBOX("/mybox/{myboxId}/server", HttpMethod.POST, true, true),

    DELETE_SERVER_ON_MYBOX("/mybox/{myboxId}/server/{serverId}", HttpMethod.DELETE, false, true),

    GET_USER("/user", HttpMethod.GET, false, true),

    GET_USER_SERVERS("/user/{userId}/servers", HttpMethod.GET, false, true),

    GET_SERVER_INFO("/server/{serverId}/", HttpMethod.GET, false, true),

    GET_SERVER_LIVE("/server/{serverId}/live", HttpMethod.GET, false, true),

    GET_MYBOX("/mybox/{myboxId}", HttpMethod.GET, false, true),

    SERVER_POWER_ACTION("/server/{serverId}/poweraction", HttpMethod.PUT, true, true);

    private final String pathTemplate;
    private final HttpMethod method;
    private final boolean hasPayload;
    private final boolean requiresBearer;

    Endpoint(String pathTemplate, HttpMethod method, boolean hasPayload, boolean requiresBearer) {
        this.pathTemplate = pathTemplate;
        this.method = method;
        this.hasPayload = hasPayload;
        this.requiresBearer = requiresBearer;
    }

    public String pathTemplate() {
        return pathTemplate;
    }

    public HttpMethod method() {
        return method;
    }

    public boolean hasPayload() {
        return hasPayload;
    }

    public boolean requiresBearer() {
        return requiresBearer;
    }
}
