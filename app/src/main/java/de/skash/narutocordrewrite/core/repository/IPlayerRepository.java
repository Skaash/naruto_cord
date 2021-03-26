package de.skash.narutocordrewrite.core.repository;

import de.skash.narutocordrewrite.core.api.ApiRequest;
import de.skash.narutocordrewrite.core.api.model.Player;

import java.util.List;

public interface IPlayerRepository {
    ApiRequest<Player> createPlayer(Player player);

    ApiRequest<List<Player>> retrievePlayer();

    List<Player> getPlayer();

    ApiRequest<Player> retrievePlayerById(long playerId);

    Player getPlayerById(long playerId);

    ApiRequest<Player> updatePlayer(Player player);

    void removePlayerFromCache(long playerId);

    ApiRequest<Void> deletePlayer(String playerId);
}
