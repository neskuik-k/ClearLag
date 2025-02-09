package fr.neskuik.clearlag;

import co.aikar.commands.PaperCommandManager;
import fr.neskuik.clearlag.commands.ClearLagCommand;
import fr.neskuik.clearlag.listener.ClearLagTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ClearLag extends JavaPlugin {

    @Override
    public void onEnable() {
        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new ClearLagCommand(this));

        new ClearLagTask(this).runTaskTimer(this, 0, 1200);

        Bukkit.getLogger().info("[ClearLag] Plugin activé !");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[ClearLag] Plugin désactivé !");
    }
}
