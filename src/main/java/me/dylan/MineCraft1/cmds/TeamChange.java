package me.dylan.MineCraft1.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
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
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;


public class TeamChange implements CommandExecutor, Listener {

    public Inventory inv;

    public TeamChange() {
        createInv();

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("changeteam")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You can't do this.");
                return true;
            }
            Player player = (Player) sender;
            player.openInventory(inv);
            return true;
        }
        return false;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        System.out.println(event.getClickedInventory());
        System.out.println(inv);
        if (!event.getView().getTitle().contains("Select Team"))
            return;
        System.out.println(event.getCurrentItem());
        if (event.getCurrentItem() == null) return;
        System.out.println(event.getCurrentItem().getItemMeta());
        if (event.getCurrentItem().getItemMeta() == null) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();

        if (event.getSlot() == 0) {
            //Blue Team
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.BLUE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team.");
        }
        if (event.getSlot() == 1) {
            //Red Team
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.RED);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team.");
        }
        if (event.getSlot() == 2) {
            //Lime Team
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.LIME);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team.");
        }
        if (event.getSlot() == 3) {
            //Orange Team
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.ORANGE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team.");
        }
        if (event.getSlot() == 4) {
            //Purple Team
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.PURPLE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team.");
        }
        if (event.getSlot() == 5) {
            //Cyan Team
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.AQUA);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team.");
        }
        if (event.getSlot() == 6) {
            //Black Team
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.BLACK);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team.");
        }
        if (event.getSlot() == 8) {
            //Close
            player.closeInventory();
        }
        return;
    }

    public ItemStack[] changeColor(ItemStack[] a, Color color) {
        for (ItemStack item : a) {
            try {
                if (item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.LEATHER_CHESTPLATE ||
                        item.getType() == Material.LEATHER_HELMET || item.getType() == Material.LEATHER_LEGGINGS) {
                    LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
                    meta.setColor(color);
                    item.setItemMeta(meta);
                }

            } catch (Exception e) {
            }
        }
        return a;
    }


    public void createInv() {

        inv = Bukkit.createInventory(null, 9, "Select Team.");

        ItemStack item = new ItemStack(Material.BLUE_CONCRETE);
        ItemMeta meta = item.getItemMeta();

        //Blue Team
        meta.setDisplayName(ChatColor.DARK_BLUE + "Blue Team");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Click to join Team");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(0, item);

        //Red Team
        item.setType(Material.RED_CONCRETE);
        meta.setDisplayName(ChatColor.DARK_RED + "Red Team");
        item.setItemMeta(meta);
        inv.setItem(1, item);

        //Lime Team
        item.setType(Material.LIME_CONCRETE);
        meta.setDisplayName(ChatColor.GREEN + "Lime Team");
        item.setItemMeta(meta);
        inv.setItem(2, item);

        //Orange Team
        item.setType(Material.ORANGE_CONCRETE);
        meta.setDisplayName(ChatColor.GOLD + "Orange Team");
        item.setItemMeta(meta);
        inv.setItem(3, item);

        //Purple Team
        item.setType(Material.PURPLE_CONCRETE);
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Team");
        item.setItemMeta(meta);
        inv.setItem(4, item);

        //Cyan Team
        item.setType(Material.CYAN_CONCRETE);
        meta.setDisplayName(ChatColor.BLUE + "Cyan Team");
        item.setItemMeta(meta);
        inv.setItem(5, item);

        //Black Team
        item.setType(Material.BLACK_CONCRETE);
        meta.setDisplayName(ChatColor.BLACK + "Black Team");
        item.setItemMeta(meta);
        inv.setItem(6, item);

        //close button
        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Menu");
        lore.clear();
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(8, item);
    }
}
