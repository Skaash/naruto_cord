package de.skash.narutocordrewrite.core.repository;

import de.skash.narutocordrewrite.core.api.ApiRequest;
import de.skash.narutocordrewrite.core.api.RequestFactory;
import de.skash.narutocordrewrite.core.api.model.Player;
import de.skash.narutocordrewrite.core.api.util.RequestRoute;
import de.skash.narutocordrewrite.core.cache.PlayerCache;

import java.util.List;

public class ApiPlayerRepository implements IPlayerRepository {
    private final RequestFactory requestFactory;
    private final PlayerCache playerCache;


    public ApiPlayerRepository(
            RequestFactory requestFactory,
            PlayerCache playerCache
    ) {
        this.requestFactory = requestFactory;
        this.playerCache = playerCache;
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
        return playerCache.getElements();
    }

    @Override
    public ApiRequest<Player> retrievePlayerById(long playerId) {
        return requestFactory.createRequest(RequestRoute.PLAYER_INDEX, String.valueOf(playerId), null);
    }

    @Override
    public Player getPlayerById(long playerId) {
        return playerCache.getElementByKey(playerId);
    }

    @Override
    public ApiRequest<Player> updatePlayer(Player player) {
        return requestFactory.createRequest(RequestRoute.PLAYER_UPDATE, player.getIdAsString(), requestFactory.mapToJsonBody(player));
    }


    @Override
    public void removePlayerFromCache(long playerId) {
        playerCache.removeElementByKey(playerId);
    }

    @Override
    public ApiRequest<Void> deletePlayer(String playerId) {
        return requestFactory.createRequest(RequestRoute.PLAYER_DELETE, String.valueOf(playerId), null);
    }
}
