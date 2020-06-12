package me.dylan.helloBitch.npc;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {
    public void onJoin(PlayerJoinEvent event){
        if (NPC.getNPCs() == null)
            return;
        if (NPC.getNPCs().isEmpty())
            return;
        NPC.addJoinPacket(event.getPlayer());
    }
}
