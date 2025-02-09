package fr.neskuik.clearlag.listener;

import fr.neskuik.clearlag.ClearLag;
import org.bukkit.scheduler.BukkitRunnable;

public class ClearLagTask extends BukkitRunnable {
    private final ClearLag plugin;

    public ClearLagTask(ClearLag plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                plugin.getServer().broadcastMessage("&7[&6⚠&7] &fSuppression des items au sol dans 5 minutes.");
            }
        }.runTaskLater(plugin, 20L * 60 * 5);

        new BukkitRunnable() {
            @Override
            public void run() {
                int removed = EntityUtils.clearEntities(plugin);
                plugin.getServer().broadcastMessage("&7[&6⚠&7] &fSuppresion des items au sol effectué.");
            }
        }.runTaskLater(plugin, 20L * 60 * 10);
    }
}