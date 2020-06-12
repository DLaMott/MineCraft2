package me.dylan.helloBitch.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig {

    private final File file;
    private FileConfiguration customFile;

    public CustomConfig(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("HelloWorld").getDataFolder(),"customconfig.yml");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }
    public FileConfiguration get(){
        return customFile;
    }
    public void save(){
        try {
            customFile.save(file);
        } catch (IOException e) {
            System.out.println("Couldn't save file.");
        }
    }

    public void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
