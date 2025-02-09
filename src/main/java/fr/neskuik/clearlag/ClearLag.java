package fr.neskuik.clearlag;

import co.aikar.commands.PaperCommandManager;
import fr.neskuik.clearlag.commands.ClearLagCommand;
import fr.neskuik.clearlag.listener.ClearLagTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ClearLag extends JavaPlugin {

    @Override
    public void onEnable() {
        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new ClearLagCommand(this));

        new ClearLagTask(this).runTaskTimer(this, 0, 1200);

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
}
