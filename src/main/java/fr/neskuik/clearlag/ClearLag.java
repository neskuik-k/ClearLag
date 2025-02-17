package fr.neskuik.clearlag;

import co.aikar.commands.PaperCommandManager;
import fr.neskuik.clearlag.commands.ClearLagCommand;
import fr.neskuik.clearlag.listener.ClearLagTask;
import fr.neskuik.clearlag.placeholders.ClearLagExpansion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ClearLag extends JavaPlugin {

    @Override
    public void onEnable() {
        // Ensure the plugin's data folder exists
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        saveDefaultConfig();

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new ClearLagCommand(this));

        new ClearLagTask(this).runTaskTimer(this, 0, 20L * 60 * getConfig().getInt("clearing-time", 10));

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            if (new ClearLagExpansion(this).register()) {
                getLogger().info("PlaceholderAPI expansion registered successfully.");
            } else {
                getLogger().warning("Failed to register PlaceholderAPI expansion.");
            }
        } else {
            getLogger().warning("PlaceholderAPI not found. Placeholders will not be available.");
        }

        System.out.println(ChatColor.WHITE + "--------------------------");
        System.out.println(" ");
        System.out.println(ChatColor.GREEN + "[ClearLag] Successfully enabled.");
        System.out.println(ChatColor.GOLD + "Plugin developed by Neskuik :)");
        System.out.println(" ");
        System.out.println(ChatColor.WHITE + "--------------------------");
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.WHITE + "--------------------------");
        System.out.println(" ");
        System.out.println(ChatColor.RED + "[ClearLag] Successfully disabled.");
        System.out.println(ChatColor.GOLD + "Plugin developed by Neskuik :)");
        System.out.println(" ");
        System.out.println(ChatColor.WHITE + "--------------------------");
    }

    public void reloadClearLagConfig() {
        reloadConfig();
    }
}