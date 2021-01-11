package me.dylan.MineCraft1.util;

import me.dylan.MineCraft1.HelloWorld;
import org.bukkit.configuration.file.FileConfiguration;


public class CustomConfig {

    private final FileConfiguration customFile;

    public CustomConfig(HelloWorld plugin) {
        this.customFile = plugin.getConfig();
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }


    public FileConfiguration get() {
        return customFile;
    }

}
