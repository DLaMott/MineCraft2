package me.dylan.helloBitch.cmds;

import me.dylan.helloBitch.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class StarTool implements CommandExecutor, Listener {

    private final Cooldown cooldown;// references the interface
    public List<String> list = new ArrayList<String>();

    public StarTool(Cooldown cooldown) { //instantiates the gay ass cooldown. Interface is utilized to use the GayAssCoolDown
        this.cooldown = cooldown;


    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("trident")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You can not use");
                return true;
            }
            Player player = (Player) sender;
            player.getInventory().addItem(getItem());
            player.sendMessage(ChatColor.GOLD + "The gods sent you a gift!");
            return true;
        }
        return false;
    }

    public ItemStack getItem() {
        //type
        ItemStack trident = new ItemStack(Material.TRIDENT);
        ItemMeta meta = trident.getItemMeta();

        meta.setDisplayName(ChatColor.MAGIC + "" + ChatColor.BOLD + "Trident of death");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right CLick) &a&oSpawn slaves."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Left Click) &a&oShoot explosives."));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LOYALTY, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);

        trident.setItemMeta(meta);
        return trident;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }
        if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.TRIDENT))
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                Player player = event.getPlayer();
                if (event.getAction() == Action.RIGHT_CLICK_AIR) {
                    if (!list.contains(player.getName()))
                        list.add(player.getName());
                    return;
                }
                if (event.getAction() == Action.LEFT_CLICK_AIR) {
                    //Cooldown being checked.
                    if (this.cooldown.isOnCooldown(player)) {
                        return;
                    }
                    player.launchProjectile(Fireball.class);
                }
            }
    }

    @EventHandler
    public void onLand(ProjectileHitEvent event) {
        if (event.getEntityType() == EntityType.TRIDENT) {
            if (event.getEntity().getShooter() instanceof Player) {
                Player player = (Player) event.getEntity().getShooter();
                if (list.contains(player.getName())) {
                    //zombie spawn
                    Location loc = event.getEntity().getLocation();
                    loc.setY(loc.getY() + 1);

                    for (int i = 1; i < 6; i++) {

                        loc.getWorld().spawnEntity(loc, EntityType.CREEPER);
                        loc.setX(loc.getX() + i);

                    }
                }
            }
        }
    }
}

