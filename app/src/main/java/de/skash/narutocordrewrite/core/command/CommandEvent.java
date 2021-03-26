package de.skash.narutocordrewrite.core.command;

import de.skash.narutocordrewrite.core.api.model.Player;
import de.skash.narutocordrewrite.core.api.model.Server;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CommandEvent {
    @Nonnull
    private final User user;

    @Nonnull
    private final TextChannel textChannel;

    @Nonnull
    private final Server server;

    @Nullable
    private final Player player;

    protected CommandEvent(
            @NotNull Message message,
            @NotNull Server server,
            @Nullable Player player
    ) {
        this.user = message.getAuthor();
        this.textChannel = message.getTextChannel();
        this.server = server;
        this.player = player;
    }

    @Nonnull
    public User getUser() {
        return user;
    }

    @Nonnull
    public TextChannel getTextChannel() {
        return textChannel;
    }

    @Nonnull
    public Server getServer() {
        return server;
    }

    @Nullable
    public Player getPlayer() {
        return player;
    }

    public void reply(String message) {
        textChannel.sendMessage(message).queue();
    }

    public void reply(EmbedBuilder embedBuilder) {
        textChannel.sendMessage(embedBuilder.build()).queue();
    }
}
