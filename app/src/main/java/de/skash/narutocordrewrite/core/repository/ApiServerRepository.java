package de.skash.narutocordrewrite.core.repository;

import de.skash.narutocordrewrite.core.api.RequestFactory;

public class ApiServerRepository implements IServerRepository {
    private final RequestFactory requestFactory;

    public ApiServerRepository(RequestFactory requestFactory) {
        this.requestFactory = requestFactory;
    }
}
