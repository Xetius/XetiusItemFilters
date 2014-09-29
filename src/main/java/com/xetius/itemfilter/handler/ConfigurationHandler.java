package com.xetius.itemfilter.handler;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(File file) {
        configuration = new Configuration(file);

        try {
            configuration.load();
        }
        catch (RuntimeException e) {

        }
        finally {
            if (configuration.hasChanged()) {
                configuration.save();
            }
        }
    }
}
