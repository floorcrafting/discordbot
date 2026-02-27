package com.floorcrafting.discordbot.lib;

public class ErrorHandler {

    public static void warning(Object... warning) {
        String[] lWarning = new String[warning.length];

        for (int i = 0; i < lWarning.length; i++)
            lWarning[i] = warning[i].toString();

        System.err.println("[WARNING] " + String.join(" ", lWarning));
    }

    public static void error(Object... error) {
        String[] lError = new String[error.length];

        for (int i = 0; i < lError.length; i++)
            lError[i] = error[i].toString();

        System.err.println("[ERROR] " + String.join(" ", lError));
    }

    public static void crash(Object... error) {
        String[] lError = new String[error.length];

        for (int i = 0; i < lError.length; i++)
            lError[i] = error[i].toString();

        System.err.println("[CRASH] " + String.join(" ", lError));
        System.exit(1);
    }
}
