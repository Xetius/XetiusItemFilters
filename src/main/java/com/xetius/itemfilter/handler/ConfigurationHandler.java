package com.xetius.itemfilter.handler;

import com.xetius.itemfilter.reference.Reference;
import com.xetius.itemfilter.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(File file) {
        if (configuration == null) {
            configuration = new Configuration(file);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
        try {
            configuration.load();
            int itemValue = configuration.get(Configuration.CATEGORY_GENERAL, "itemValue", 13).getInt();
        }
        catch (RuntimeException e) {
            LogHelper.error(e.getMessage());
        }
        finally {
            if (configuration.hasChanged()) {
                configuration.save();
            }
        }

    }
}
