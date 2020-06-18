package me.dylan.helloBitch.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("mystat")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You can not run this command");
                return true;
            }
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Usage: /mystat {deaths/logins/mobKills/playerKills/damage");
                return true;
            }
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("deaths")) {
                    player.sendMessage("you have" + player.getStatistic(Statistic.DEATHS) + "deaths");
                    return true;
                }
                if (args[0].equalsIgnoreCase("logins")) {
                    player.sendMessage("you have" + (player.getStatistic(Statistic.LEAVE_GAME) + 1) + "total logins");
                    return true;
                }
                if (args[0].equalsIgnoreCase("mobKills")) {
                    player.sendMessage("you have" + player.getStatistic(Statistic.MOB_KILLS) + "mob kills");
                    return true;
                }
                if (args[0].equalsIgnoreCase("playerKills")) {
                    player.sendMessage("you have" + player.getStatistic(Statistic.PLAYER_KILLS) + "player kills");
                    return true;
                }
                if (args[0].equalsIgnoreCase("playerKills")) {
                    player.sendMessage("you inflicted" + player.getStatistic(Statistic.DAMAGE_DEALT) + "damage");
                    return true;
                }
            }
        }
        return true;
    }
}
