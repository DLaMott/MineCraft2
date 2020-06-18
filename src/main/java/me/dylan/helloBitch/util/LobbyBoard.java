package me.dylan.helloBitch.util;

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LobbyBoard {
    private static final Map<UUID, Integer> TASKS = new HashMap<UUID, Integer>();
    private final UUID uuid;

    public LobbyBoard(UUID uuid) {
        this.uuid = uuid;
    }

    public int getID() {
        return TASKS.get(uuid);
    }

    public void setID(int id) {
        TASKS.put(uuid, id);

    }

    public boolean hasID() {
        return TASKS.containsKey(uuid);
    }

    public void stop() {
        Bukkit.getScheduler().cancelTask(TASKS.get(uuid));
        TASKS.remove(uuid);
    }
}
