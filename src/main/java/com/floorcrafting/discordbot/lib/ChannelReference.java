package com.floorcrafting.discordbot.lib;

import org.jetbrains.annotations.NotNull;

public class ChannelReference {

    public static @NotNull String text(long id) {
        return "<#" + id + ">";
    }
}
