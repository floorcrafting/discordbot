package com.floorcrafting.discordbot.commands;

import com.floorcrafting.discordbot.commands.lib.BotC;
import com.floorcrafting.discordbot.lib.ChannelReference;
import com.floorcrafting.discordbot.lib.RuntimeProperties;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

public class GithubC extends BotC {

    @Override
    public @NotNull String name() {
        return "github";
    }

    @Override
    public @NotNull String description() {
        return "Sends you the official GitHub repository of Floorcraft";
    }

    @Override
    public void execute(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage("Visit the " + ChannelReference.text(RuntimeProperties.githubChannelId()) + " channel for a link to our public source code").queue();
    }
}
