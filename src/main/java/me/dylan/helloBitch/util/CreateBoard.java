package me.dylan.helloBitch.util;

import me.dylan.helloBitch.HelloWorld;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class CreateBoard {
    private final HelloWorld plugin;

    public CreateBoard(HelloWorld plugin) {
        this.plugin = plugin;
    }

    public void loadBoard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("HelloScoreBoard", "dummy",
                ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1ScoreTrack &a&1>>"));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = obj.getScore(ChatColor.BLUE + "=-=-=-=-=-=-=-=");
        score.setScore(3);
        Score score2 = obj.getScore(ChatColor.AQUA + "Online Players" + ChatColor.DARK_AQUA + Bukkit.getOnlinePlayers().size());
        score2.setScore(2);
        Score score3 = obj.getScore(ChatColor.RED + "Mob Kills" + ChatColor.DARK_RED + player.getStatistic(Statistic.MOB_KILLS));
        score3.setScore(1);
        Score score4 = obj.getScore(ChatColor.RED + "Deaths" + ChatColor.DARK_RED + player.getStatistic(Statistic.DEATHS));
        score4.setScore(0);
        player.setScoreboard(board);


    }
}
