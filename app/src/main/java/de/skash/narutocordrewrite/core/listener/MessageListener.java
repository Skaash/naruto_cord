package de.skash.narutocordrewrite.core.listener;

import de.skash.narutocordrewrite.core.api.model.Server;
import de.skash.narutocordrewrite.core.command.CommandHandler;
import de.skash.narutocordrewrite.core.repository.IServerRepository;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageListener extends ListenerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(MessageListener.class);
    private final CommandHandler commandHandler;
    private final IServerRepository serverRepository;

    public MessageListener(
            CommandHandler commandHandler,
            IServerRepository serverRepository
    ) {
        this.commandHandler = commandHandler;
        this.serverRepository = serverRepository;
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        var serverId = event.getGuild().getIdLong();
        var server = serverRepository.getServerById(serverId);

        if (server != null) {
            commandHandler.handleCommand(event.getMessage(), server);
            return;
        }

        serverRepository.retrieveServerById(event.getGuild().getId()).executeAsync(success ->
                        commandHandler.handleCommand(event.getMessage(), success),
                error -> LOG.error("onGuildMessageReceived :: error", error));
    }
}
