package de.skash.narutocordrewrite.core.command;

public abstract class Command {

    public abstract void execute(CommandEvent event);

    public abstract String getKeyword();

    public abstract String getDescription();

    public abstract String getHelp();
}
