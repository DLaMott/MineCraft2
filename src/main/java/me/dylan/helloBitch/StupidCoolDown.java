package me.dylan.helloBitch;

import me.dylan.helloBitch.util.NumberUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class StupidCoolDown implements Cooldown {
    public final int coolDownSeconds = NumberUtil.rnd(10);
    private final Map<String, Long> cooldown = new HashMap<String, Long>();
    private final String name;

    public StupidCoolDown(String name) {
        this.name = name;

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
            long dick = cooldown.get(p.getName());
            //time that player is in the cooldown.
            long timeleft = dick - (System.currentTimeMillis() / 1000);
            //time player in cooldown - current world time.
            if (timeleft <= 0) { // player is sent out if time is lessthan or equal to zero.
                clear(p);
                return false;
            }
            p.sendMessage(ChatColor.GOLD + " Ability will be ready in " + timeleft + " second(s) ");
            return true;

        }
        cooldown.put(p.getName(), System.currentTimeMillis() / 1000 + coolDownSeconds);
        return false;
    }

    @Override
    public void clear(Player p) {
        cooldown.remove(p.getName());
    }

}


