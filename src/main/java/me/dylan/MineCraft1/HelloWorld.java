package me.dylan.MineCraft1;

import me.dylan.MineCraft1.cmds.*;
import me.dylan.MineCraft1.util.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

//This is the main class. Main class extends JavaPlugin. Only one class can have java plugin...It is needed for imports.
public class HelloWorld extends JavaPlugin {
    //The class is public:Able to be called by other classes. The Class is defined as HelloWorld then extends java plugin.
    private CustomConfig customConfig;


    @Override
    public void onEnable() {
        //void means values are not returned. onEnable means any methods/classes in this area will be loaded at start up.
        StarTool starTool = new StarTool(new anotherCoolDown("CoolDown"));
        //         program to the interface to use any concrete class in its place.
//        StarTool starTool= new StarTool(new CoolDown("CoolDown1", 5d)); //This can be used for a set cooldown limit of 5
        customConfig = new CustomConfig(this);
        CustomRecipe cr = new CustomRecipe(this);
        CreateBoard CBB = new CreateBoard(this);
        ScoreBoardStart St = new ScoreBoardStart(this);

//        customConfig.get().addDefault("", "");
//        customConfig.get().options().copyDefaults(true);
//        customConfig.save(); //Moved to comments because if the config is saved on startup it will overwrite.
//these are used to call classes that use commands. If not placed in our main they will not load into the plugin.
        this.getCommand("hello").setExecutor(new HelloCmd());
        this.getCommand("launch").setExecutor(new Launchit(69));
        this.getCommand("fly").setExecutor(new FlyFar());
        this.getCommand("doctor").setExecutor(new Heal());
        this.getCommand("godboots").setExecutor(new GodBootz());
        this.getCommand("trident").setExecutor(starTool);
        this.getCommand("changeteam").setExecutor(new TeamChange());
        this.getCommand("gamble").setExecutor(new Gamble(this));
        this.getCommand("skull").setExecutor(new Skull());
        this.getCommand("mystat").setExecutor(new StatCommand());
        this.getCommand("mystat").setTabCompleter(new StatTab());
        this.getCommand("kits").setExecutor(new KitGui());
        this.getServer().addRecipe(cr.getRecipe());


//Strings below call our Event listeners from our classes.
        this.getServer().getPluginManager().registerEvents(new GodBootz(), this);
        this.getServer().getPluginManager().registerEvents(starTool, this);
        this.getServer().getPluginManager().registerEvents(new TeamChange(), this);
        this.getServer().getPluginManager().registerEvents(new Gamble(this), this);
        this.getServer().getPluginManager().registerEvents(new BlockBreak(this), this);
        this.getServer().getPluginManager().registerEvents(new KitGui(), this);

        this.getServer().getPluginManager().registerEvents(new BoardOnJoin(this), this);
        if (!Bukkit.getOnlinePlayers().isEmpty())
            for (Player online : Bukkit.getOnlinePlayers()) {
                CBB.loadBoard(online);
                St.Start(online);
            }


        this.getServer().getPluginManager().registerEvents(new BoardOnQuit(this), this);


    }

    @Override
    public void onDisable() {


    }

    public CustomConfig getCustomConfig() {
        return customConfig;
    }

}

