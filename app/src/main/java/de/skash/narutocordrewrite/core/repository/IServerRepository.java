package de.skash.narutocordrewrite.core.repository;

import de.skash.narutocordrewrite.core.api.ApiRequest;
import de.skash.narutocordrewrite.core.api.model.Server;

import java.util.List;

public interface IServerRepository {
    ApiRequest<Server> retrieveServerById(String id);
    Server getServerById(long id);

    ApiRequest<List<Server>> retrieveServer();
    List<Server> getServer();

    ApiRequest<Server> updateServer(Server updatedServer);
    void updateLocalServer(Server updatedServer);

    ApiRequest<Void> deleteServer(String id);
    void removeServerFromCache(long id);
}
