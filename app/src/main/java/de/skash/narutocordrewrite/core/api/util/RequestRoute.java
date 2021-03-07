package de.skash.narutocordrewrite.core.api.util;

import com.google.gson.reflect.TypeToken;
import de.skash.narutocordrewrite.core.model.PlayerImpl;

import java.lang.reflect.Type;
import java.util.List;

public enum RequestRoute {
    PLAYER_INDEX("player/", getTypeAsList(PlayerImpl.class), "player", RequestType.GET),
    PLAYER_SHOW("player/", PlayerImpl.class, "player", RequestType.GET),
    PLAYER_CREATE("player/", Void.class, "player", RequestType.POST),
    PLAYER_DELETE("player/", Void.class, "player", RequestType.DELETE),
    PLAYER_UPDATE("player/", PlayerImpl.class, "player", RequestType.POST);

    private final String route;
    private final Type type;
    private final String jsonKey;
    private final RequestType requestType;

    RequestRoute(
            String url,
            Type type,
            String jsonKey,
            RequestType requestType
    ) {
        this.route = url;
        this.type = type;
        this.jsonKey = jsonKey;
        this.requestType = requestType;
    }

    public String getRoute() {
        return route;
    }

    public Type getType() {
        return type;
    }

    public String getJsonKey() {
        return jsonKey;
    }

    private static Type getTypeAsList(Type type) {
        return TypeToken.getParameterized(List.class, type).getType();
    }

    public RequestType getRequestType() {
        return requestType;
    }
}
