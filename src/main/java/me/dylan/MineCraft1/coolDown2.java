package me.dylan.MineCraft1;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class coolDown2 implements Cooldown {
    //This is a map from player name to cooldowntime left.
    private final Map<String, Long> cooldown = new HashMap<String, Long>();
    private final String name;
    private final double coolDownSeconds;
//these are fields

    public coolDown2(String name, double coolDownSeconds) {
        this.coolDownSeconds = coolDownSeconds;
        this.name = name;
        //constructor is initializing fields.
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isOnCooldown(Player p) {
        if (cooldown.containsKey(p.getName())) {
            //player in hashmap.

            //player time variable
            long l = cooldown.get(p.getName());
            //time that player is in the cooldown.
            long timeleft = l - (System.currentTimeMillis() / 1000);
            //time player in cooldown - current world time.
            if (timeleft <= 0) { // player is sent out if time is lessthan or equal to zero.
                clear(p);
                return false;
            }
            p.sendMessage(ChatColor.GOLD + " Ability will be ready in " + timeleft + " second(s) ");
            return true;

        }
        cooldown.put(p.getName(), (long) (System.currentTimeMillis() / 1000 + coolDownSeconds));
        return false;
    }

    @Override
    public void clear(Player p) {
        cooldown.remove(p.getName());

    }
}

