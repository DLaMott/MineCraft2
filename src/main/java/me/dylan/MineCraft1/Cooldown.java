package me.dylan.MineCraft1;

import org.bukkit.entity.Player;

//Can be used for any cooldown classes I create.
public interface Cooldown {
    String getName();

    boolean isOnCooldown(Player p);

    void clear(Player p);

}
