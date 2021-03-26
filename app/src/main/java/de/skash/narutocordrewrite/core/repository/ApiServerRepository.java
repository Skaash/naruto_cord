package de.skash.narutocordrewrite.core.repository;

import de.skash.narutocordrewrite.core.api.ApiRequest;
import de.skash.narutocordrewrite.core.api.RequestFactory;
import de.skash.narutocordrewrite.core.api.model.Server;
import de.skash.narutocordrewrite.core.api.util.RequestRoute;
import de.skash.narutocordrewrite.core.cache.ServerCache;

import java.util.List;

public class ApiServerRepository implements IServerRepository {
    private final RequestFactory requestFactory;
    private final ServerCache serverCache;

    public ApiServerRepository(
            RequestFactory requestFactory,
            ServerCache serverCache
    ) {
        this.requestFactory = requestFactory;
        this.serverCache = serverCache;
    }

    @Override
    public ApiRequest<Server> retrieveServerById(String id) {
        return requestFactory.createRequest(RequestRoute.SERVER_SHOW, id, null);
    }

    @Override
    public Server getServerById(long id) {
        return serverCache.getElementByKey(id);
    }

    @Override
    public ApiRequest<List<Server>> retrieveServer() {
        return requestFactory.createRequest(RequestRoute.SERVER_INDEX, "", null);
    }

    @Override
    public List<Server> getServer() {
        return serverCache.getElements();
    }

    @Override
    public ApiRequest<Server> updateServer(Server updatedServer) {
        return requestFactory.createRequest(RequestRoute.SERVER_UPDATE, updatedServer.getIdAsString(), requestFactory.mapToJsonBody(updatedServer));
    }

    @Override
    public void updateLocalServer(Server updatedServer) {
        //Elements are immutable
        serverCache.removeElementByKey(updatedServer.getId());
        serverCache.cacheElement(updatedServer);
    }

    @Override
    public ApiRequest<Void> deleteServer(String id) {
        return requestFactory.createRequest(RequestRoute.SERVER_DELETE, id, null);
    }

    @Override
    public void removeServerFromCache(long id) {
        serverCache.removeElementByKey(id);
    }
}
