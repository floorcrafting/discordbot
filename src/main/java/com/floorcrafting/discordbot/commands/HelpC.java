package com.floorcrafting.discordbot.commands;

import com.floorcrafting.discordbot.BotCommands;
import com.floorcrafting.discordbot.commands.lib.BotC;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HelpC extends BotC {

    @Override
    public @NotNull String name() {
        return "help";
    }

    @Override
    public @NotNull String description() {
        return "(This message) explains how to use commands provided by me! :D";
    }

    @Override
    public void execute(String[] args, MessageReceivedEvent event) {
        List<String> messageLines = new ArrayList<>();
        messageLines.add("**] Command Help**");

        for (BotC command : BotCommands.asList())
            messageLines.add("`!" + command.name() + "` — " + command.description());

        event.getChannel().sendMessage(String.join("\n", messageLines)).queue();
    }
}
