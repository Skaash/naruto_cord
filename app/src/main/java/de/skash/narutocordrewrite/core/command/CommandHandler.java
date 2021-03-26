package de.skash.narutocordrewrite.core.command;

import de.skash.narutocordrewrite.core.api.model.Server;
import de.skash.narutocordrewrite.core.cache.CommandCache;
import de.skash.narutocordrewrite.core.cache.PlayerCache;
import de.skash.narutocordrewrite.core.repository.IPlayerRepository;
import net.dv8tion.jda.api.entities.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

public class CommandHandler {
    private final static Logger LOG = LoggerFactory.getLogger(CommandHandler.class);
    private final CommandCache commandCache;
    private final PlayerCache playerCache;
    private final IPlayerRepository playerRepository;

    public CommandHandler(
            CommandCache commandCache,
            PlayerCache playerCache,
            IPlayerRepository playerRepository
    ) {
        this.commandCache = commandCache;
        this.playerCache = playerCache;
        this.playerRepository = playerRepository;
        registerCommands();
    }

    public void handleCommand(Message message, Server server) {
        if (!message.getContentRaw().startsWith(server.getPrefix())) return;

        var command = parseCommand(message, server);

        if (command == null) return;

        var player = playerCache.getElementByKey(message.getAuthor().getIdLong());

        if (player != null) {
            command.execute(new CommandEvent(message, server, player));
            return;
        }

        playerRepository.retrievePlayerById(message.getAuthor().getIdLong()).executeAsync(success -> {
                    command.execute(new CommandEvent(message, server, success));
                },
                error -> {
                    LOG.error("handleCommand :: error", error);
                    command.execute(new CommandEvent(message, server, null));
                });
    }

    private Command parseCommand(Message message, Server server) {
        var keyword = message.getContentRaw().split("\\s")[0].substring(server.getPrefix().length());

        return commandCache.getElementByKey(keyword);
    }

    private void registerCommands() {
        //commandCache.cacheElement(new TestCommand());
        loadCommands();
    }

    private void loadCommands() {
        commandCache.getElements()
                .forEach(commandCache::cacheElement);
    }
}
