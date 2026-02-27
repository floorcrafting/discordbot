package com.floorcrafting.discordbot.lib;

import org.jetbrains.annotations.Nullable;

public class RuntimeProperties {
    private static @Nullable String botToken;
    private static long commandsChannelId;
    private static long downloadsChannelId;
    private static long githubChannelId;
    private static long countingChannelId;

    public static @Nullable String botToken() {
        return botToken;
    }

    public static long commandsChannelId() {
        return commandsChannelId;
    }

    public static long downloadsChannelId() {
        return downloadsChannelId;
    }

    public static long githubChannelId() {
        return githubChannelId;
    }

    public static long countingChannelId() {
        return countingChannelId;
    }

    public static void init() {
        String lBotToken = System.getenv("BOT_TOKEN");
        String lCommandsChannelId = System.getenv("COMMANDS_CHANNEL_ID");
        String lDownloadsChannelId = System.getenv("DOWNLOADS_CHANNEL_ID");
        String lGithubChannelId = System.getenv("GITHUB_CHANNEL_ID");
        String lCountingChannelId = System.getenv("COUNTING_CHANNEL_ID");

        if (lBotToken == null || lBotToken.isEmpty()) {
            ErrorHandler.crash("Missing bot token! Please set the BOT_TOKEN environment variable, or the bot will not run.");
            return;
        }

        if (lCommandsChannelId == null || lCommandsChannelId.isEmpty()) {
            ErrorHandler.crash("Missing commands channel ID! Please set the COMMANDS_CHANNEL_ID environment variable, or the bot will not run.");
            return;
        }

        if (lDownloadsChannelId == null || lDownloadsChannelId.isEmpty()) {
            ErrorHandler.crash("Missing downloads channel ID! Please set the DOWNLOADS_CHANNEL_ID environment variable, or the bot will not run.");
            return;
        }

        if (lGithubChannelId == null || lGithubChannelId.isEmpty()) {
            ErrorHandler.crash("Missing github channel ID! Please set the GITHUB_CHANNEL_ID environment variable, or the bot will not run.");
            return;
        }

        if (lCountingChannelId == null || lCountingChannelId.isEmpty()) {
            ErrorHandler.crash("Missing counting channel ID! Please set the COUNTING_CHANNEL_ID environment variable, or the bot will not run.");
            return;
        }

        botToken = lBotToken;
        commandsChannelId = Long.parseLong(lCommandsChannelId);
        downloadsChannelId = Long.parseLong(lDownloadsChannelId);
        githubChannelId = Long.parseLong(lGithubChannelId);
        countingChannelId = Long.parseLong(lCountingChannelId);
    }
}
