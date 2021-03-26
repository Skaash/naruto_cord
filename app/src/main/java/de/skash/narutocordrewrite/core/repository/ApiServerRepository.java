package de.skash.narutocordrewrite.core.repository;

import de.skash.narutocordrewrite.core.api.ApiRequest;
import de.skash.narutocordrewrite.core.api.RequestFactory;
import de.skash.narutocordrewrite.core.api.model.Server;
import de.skash.narutocordrewrite.core.api.util.RequestRoute;

import java.util.List;

public class ApiServerRepository implements IServerRepository {
    private final RequestFactory requestFactory;
    //TODO("Server Cache")

    public ApiServerRepository(RequestFactory requestFactory) {
        this.requestFactory = requestFactory;
    }

    @Override
    public ApiRequest<Server> retrieveServerById(String id) {
        return requestFactory.createRequest(RequestRoute.SERVER_SHOW, id, null);
    }

    @Override
    public Server getServerById(long id) {
        //TODO("Pull from Cache")
        return null;
    }

    @Override
    public ApiRequest<List<Server>> retrieveServer() {
        return requestFactory.createRequest(RequestRoute.SERVER_INDEX, "", null);
    }

    @Override
    public List<Server> getServer() {
        //TODO("Pull from Cache")
        return null;
    }

    @Override
    public ApiRequest<Server> updateServer(Server updatedServer) {
        return requestFactory.createRequest(RequestRoute.SERVER_UPDATE, updatedServer.getIdAsString(), requestFactory.mapToJsonBody(updatedServer));
    }

    @Override
    public void updateLocalServer(Server updatedServer) {
        //TODO("Update cached server")
    }
}
