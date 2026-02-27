package com.floorcrafting.discordbot.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PersistentData {
    private static final String FILE_PATH = "bot.dpd";
    private static final Properties properties = new Properties();

    public static String get(String key) {
        return get(key, null);
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static void set(String key, String value) {
        properties.setProperty(key, value);
        save();
    }

    public static void load() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            save();
            return;
        }

        try (FileInputStream in = new FileInputStream(file)) {
            properties.load(in);
        } catch (IOException ex) {
            ErrorHandler.error("Could not load database!", ex);
        }
    }

    public static void save() {
        try (FileOutputStream out = new FileOutputStream(FILE_PATH)) {
            properties.store(out, "Floorcrafty Bot Storage");
        } catch (IOException ex) {
            ErrorHandler.error("Could not save database!", ex);
        }
    }
}
