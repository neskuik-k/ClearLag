package fr.neskuik.clearlag.placeholders;

import fr.neskuik.clearlag.ClearLag;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClearLagExpansion extends PlaceholderExpansion {

    private final ClearLag plugin;

    public ClearLagExpansion(ClearLag plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "clearlag";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Neskuik";
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String identifier) {
        if (identifier.equals("warning_time")) {
            return String.valueOf(plugin.getConfig().getInt("warning-time", 5));
        }

        if (identifier.equals("clearing_time")) {
            return String.valueOf(plugin.getConfig().getInt("clearing-time", 10));
        }

        return null;
    }
}