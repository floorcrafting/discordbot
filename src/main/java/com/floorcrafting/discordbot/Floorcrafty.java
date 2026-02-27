package com.floorcrafting.discordbot;

import com.floorcrafting.discordbot.channelshit.Counting;
import com.floorcrafting.discordbot.commands.DownloadC;
import com.floorcrafting.discordbot.commands.GithubC;
import com.floorcrafting.discordbot.commands.HelpC;
import com.floorcrafting.discordbot.commands.InviteC;
import com.floorcrafting.discordbot.lib.PersistentData;
import com.floorcrafting.discordbot.lib.RuntimeProperties;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Floorcrafty extends ListenerAdapter {

    public void init() {
        BotCommands.register(HelpC.class);
        BotCommands.register(InviteC.class);
        BotCommands.register(DownloadC.class);
        BotCommands.register(GithubC.class);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        long channelId = event.getChannel().getIdLong();
        if (channelId == RuntimeProperties.countingChannelId()) {
            new Counting().onMessageReceived(event);
            return;
        }

        if (channelId != RuntimeProperties.commandsChannelId()) return;
        BotCommands.handle(event);
    }

    private static JDA bot;

    public static JDA bot() {
        return bot;
    }

    static void main() {
        RuntimeProperties.init();
        PersistentData.load();
        Floorcrafty floorcrafty = new Floorcrafty();
        bot = JDABuilder.createDefault(RuntimeProperties.botToken()).enableIntents(GatewayIntent.MESSAGE_CONTENT).setActivity(Activity.playing("Obeying your every command")).addEventListeners(floorcrafty).build();
        floorcrafty.init();
    }
}
