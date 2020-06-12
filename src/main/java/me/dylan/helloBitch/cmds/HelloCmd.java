package me.dylan.helloBitch.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCmd implements CommandExecutor {
    //A constructor to create an object in order to use it
    public HelloCmd() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to da crib my dudes");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1H&2a&3v&4e&5 &6F&7u&8n&9!"));
            return true;
        } else {
            // server, console
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "Hey Shithead!");
            return true;
        }
    }
}
