package me.dylan.helloBitch.util;

import me.dylan.helloBitch.HelloWorld;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

public class ScoreBoardStart {
    private final HelloWorld plugin;
    private int taskID;

    public ScoreBoardStart(HelloWorld plugin) {
        this.plugin = plugin;
    }

    public void Start(Player player) {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            final LobbyBoard board = new LobbyBoard(player.getUniqueId());
            int count = 0;

            @Override
            public void run() {
                if (!board.hasID()) {
                    board.setID(taskID);
                }
                if (count == 13) {
                    count = 0;
                }
                switch (count) {
                    case 0:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1ScoreTrack &a&1>>"));
                        break;
                    case 1:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&1S&2c&1oreTrack &a&1>>"));
                        break;
                    case 2:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1S&dc&1o&2r&1eTrack &a&1>>"));
                        break;
                    case 3:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1Sc&do&1r&2e&1Track &a&1>>"));
                        break;
                    case 4:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1Sco&dr&1e&2T&1rack &a&1>>"));
                        break;
                    case 5:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1Scor&de&1T&2r&1ack &a&1>>"));
                        break;
                    case 6:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1Score&dT&1r&2a&1ck &a&1>>"));
                        break;
                    case 7:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1ScoreT&dr&1a&2c&1k &a&1>>"));
                        break;
                    case 8:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1ScoreTr&da&1c&2k &a&1>>"));
                        break;
                    case 9:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1ScoreTra&dc&1k &a&1>>"));
                        break;
                    case 10:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&1ScoreTrack &a&1>>"));
                        break;
                    case 11:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&1ScoreTrack &a&1>>"));
                        break;
                    case 12:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                                .setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&1ScoreTrack &a&1>>"));
                        new CreateBoard(plugin).loadBoard(player);
                        break;
                }
                count++;

            }
        }, 0, 10);
    }
}
