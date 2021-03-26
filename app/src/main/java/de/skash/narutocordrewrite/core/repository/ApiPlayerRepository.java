package de.skash.narutocordrewrite.core.repository;

import de.skash.narutocordrewrite.core.api.ApiRequest;
import de.skash.narutocordrewrite.core.api.RequestFactory;
import de.skash.narutocordrewrite.core.api.model.Player;
import de.skash.narutocordrewrite.core.api.util.RequestRoute;

import java.util.List;

public class ApiPlayerRepository implements IPlayerRepository {
    private final RequestFactory requestFactory;
    //TODO("Player Cache")


    public ApiPlayerRepository(RequestFactory requestFactory) {
        this.requestFactory = requestFactory;
    }

    @Override
    public ApiRequest<Player> createPlayer(Player player) {
        return requestFactory.createRequest(RequestRoute.PLAYER_CREATE, "", requestFactory.mapToJsonBody(player));
    }

    @Override
    public ApiRequest<List<Player>> retrievePlayer() {
        return requestFactory.createRequest(RequestRoute.PLAYER_INDEX, "", null);
    }

    @Override
    public List<Player> getPlayer() {
        //TODO: Pull from cache
        return null;
    }

    @Override
    public ApiRequest<Player> retrievePlayerById(long playerId) {
        return requestFactory.createRequest(RequestRoute.PLAYER_INDEX, String.valueOf(playerId), null);
    }

    @Override
    public Player getPlayerById(long playerId) {
        //TODO: Pull from cache
        return null;
    }

    @Override
    public ApiRequest<Player> updatePlayer(Player player) {
        return requestFactory.createRequest(RequestRoute.PLAYER_UPDATE, "player.getId()", requestFactory.mapToJsonBody(player));
    }

    @Override
    public void removePlayerFromCache(long playerId) {
        //TODO: Remove from cache
    }

    @Override
    public ApiRequest<Void> deletePlayer(long playerId) {
        return requestFactory.createRequest(RequestRoute.PLAYER_DELETE, String.valueOf(playerId), null);
    }
}
