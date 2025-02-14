package fr.neskuik.clearlag.listener;

import fr.neskuik.clearlag.ClearLag;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;

public class EntityUtils {

    public static int clearEntities(ClearLag plugin) {
        int removedEntities = 0;

        for (Entity entity : Bukkit.getWorlds().get(0).getEntities()) {
            if (entity instanceof Item || isMob(entity)) {
                entity.remove();
                removedEntities++;
            }
        }

        return removedEntities;
    }

    private static boolean isMob(Entity entity) {
        EntityType type = entity.getType();
        return type == EntityType.ZOMBIE ||
                type == EntityType.SKELETON ||
                type == EntityType.CREEPER ||
                type == EntityType.SPIDER ||
                type == EntityType.ENDERMAN ||
                type == EntityType.WITCH ||
                type == EntityType.SLIME ||
                type == EntityType.GHAST ||
                type == EntityType.PIGLIN ||
                type == EntityType.BLAZE ||
                type == EntityType.MAGMA_CUBE ||
                type == EntityType.SILVERFISH ||
                type == EntityType.ENDERMITE ||
                type == EntityType.GUARDIAN ||
                type == EntityType.SHULKER ||
                type == EntityType.VEX ||
                type == EntityType.VINDICATOR ||
                type == EntityType.EVOKER ||
                type == EntityType.PILLAGER ||
                type == EntityType.RAVAGER ||
                type == EntityType.PHANTOM;
    }
}