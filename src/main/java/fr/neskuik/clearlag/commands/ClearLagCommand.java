package fr.neskuik.clearlag.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import fr.neskuik.clearlag.ClearLag;
import fr.neskuik.clearlag.listener.EntityUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

@CommandAlias("clearlag")
@CommandPermission("responsable")
public class ClearLagCommand extends BaseCommand {
    private final ClearLag plugin;

    public ClearLagCommand(ClearLag plugin) {
        this.plugin = plugin;
    }

    @Default("clearlag")
    public void onClearLag(CommandSender sender) {
        int removed = EntityUtils.clearEntities(plugin);
        sender.sendMessage("§6§lSKYMC §f§l• §7Suppression de " + removed + " entités §aeffectué(e)§7 !");
        Bukkit.broadcastMessage("§7[§6⚠§7] §fSuppresion des items au sol effectué.");
    }
}