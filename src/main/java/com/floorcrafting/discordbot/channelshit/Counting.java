package com.floorcrafting.discordbot.channelshit;

import com.floorcrafting.discordbot.lib.PersistentData;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counting extends ListenerAdapter {
    private final Pattern intPattern = Pattern.compile("(?<![A-Za-z0-9_])-?\\d+(?![A-Za-z0-9_])");

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String rawMessage = event.getMessage().getContentRaw();

        try {
            int current = Integer.parseInt(PersistentData.get("count", "0"));
            int next = current + 1;
            int number = extractInt(rawMessage);
            if (number != next) {
                next = 1;
                event.getChannel().sendMessage("**Wrong!** The next number is now **" + next + "**.").queue();
                event.getMessage().addReaction(Emoji.fromUnicode("U+274C")).queue();
                PersistentData.set("count", String.valueOf(0));
                return;
            }

            PersistentData.set("count", String.valueOf(next));
            event.getMessage().addReaction(Emoji.fromUnicode("U+2705")).queue();
        } catch (NumberFormatException ignored) {
        }
    }

    private int extractInt(String input) throws NumberFormatException {
        List<Integer> numbers = new ArrayList<>();
        Matcher matcher = intPattern.matcher(input);
        while (matcher.find()) numbers.add(Integer.parseInt(matcher.group()));
        if (numbers.isEmpty()) throw new NumberFormatException("Contains no number");
        return numbers.getFirst();
    }
}
