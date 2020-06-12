package me.dylan.helloBitch.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Launchit implements CommandExecutor {
    private final int y;

    public Launchit(int y) {
        this.y = y;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("*console goes flying*");
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.BLUE + "Zoooom!");
            player.setVelocity(player.getLocation().getDirection().multiply(2).setY(this.y));

            return true;
        }
        player.sendMessage(ChatColor.AQUA + "Zoooom!");
        player.setVelocity(player.getLocation().getDirection().multiply(Long.parseLong(args[0])).setY(2));
        return true;
    }

}

