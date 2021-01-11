package me.dylan.MineCraft1.cmds;

import me.dylan.MineCraft1.HelloWorld;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Gamble implements Listener, CommandExecutor {

    public static ItemStack[] contents;
    private final HelloWorld plugin;
    List<Inventory> invs = new ArrayList<Inventory>();
    private int itemIndex = 0;

    public Gamble(HelloWorld plugin) {

        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("gamble")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You can not gamble!");
                return true;
            }
            Player player = (Player) sender;
            ItemStack fee = new ItemStack(Material.DIAMOND);
            fee.setAmount(1);
            if (player.getInventory().getItemInMainHand().isSimilar(fee)) {
                player.getInventory().removeItem(fee);
                spin(player);

                return true;
            }
            player.sendMessage(ChatColor.RED + "You dont have enough diamonds!");
            return true;
        }
        return false;
    }

    public void shuffle(Inventory inv) {
        if (contents == null) {
            ItemStack[] items = new ItemStack[10];

            items[0] = new ItemStack(Material.COARSE_DIRT, 32);
            items[1] = new ItemStack(Material.DIAMOND, 3);
            items[2] = new ItemStack(Material.COW_SPAWN_EGG, 1);
            items[3] = new ItemStack(Material.GOLD_INGOT, 3);
            items[4] = new ItemStack(Material.EMERALD, 5);
            items[5] = new ItemStack(Material.NETHER_STAR, 1);
            items[6] = new ItemStack(Material.IRON_ORE, 5);
            items[7] = new ItemStack(Material.GUARDIAN_SPAWN_EGG, 1);
            items[8] = new ItemStack(Material.ARROW, 5);
            items[9] = new ItemStack(Material.BARRIER, 1);

            contents = items;
        }
        int startingIndex = ThreadLocalRandom.current().nextInt(contents.length);
        for (int index = 0; index < startingIndex; index++) {
            for (int itemstacks = 9; itemstacks < 18; itemstacks++) {
                inv.setItem(itemstacks, contents[(itemstacks + itemIndex) % contents.length]);
            }
            itemIndex++;
        }
        ItemStack item = new ItemStack(Material.HOPPER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "|");
        item.setItemMeta(meta);
        inv.setItem(4, item);
    }

    public void spin(final Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "Good Luck!");
        shuffle(inv);
        invs.add(inv);
        player.openInventory(inv);

        Random r = new Random();
        double seconds = 7.0 + (12.0 - 7.0) * r.nextDouble();

        new BukkitRunnable() {
            double delay = 0;
            int ticks = 0;
            boolean done = false;

            public void run() {
                if (done)
                    return;
                ticks++;
                delay += 1 / (20 * seconds);
                if (ticks > delay * 10) {
                    ticks = 0;
                    for (int itemstacks = 9; itemstacks < 18; itemstacks++)
                        inv.setItem(itemstacks, contents[(itemstacks + itemIndex) % contents.length]);
                    itemIndex++;
                    if (delay >= .5) {
                        done = true;
                        new BukkitRunnable() {
                            public void run() {
                                ItemStack item = inv.getItem(13);
                                player.getInventory().addItem(item);
                                player.updateInventory();
                                player.closeInventory();
                                cancel();
                            }
                        }.runTaskLater(plugin, 50);
                        cancel();
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 1);


    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().contains("Good Luck!"))
            return;
        event.setCancelled(true);
    }


}
