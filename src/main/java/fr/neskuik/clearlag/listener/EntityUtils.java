package fr.neskuik.clearlag.listener;

import fr.neskuik.clearlag.ClearLag;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;

public class EntityUtils {

    public static int clearEntities(ClearLag plugin) {
        int count = 0;

        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (entity instanceof Item || entity instanceof Monster) {
                    entity.remove();
                    count++;
                }
            }
        }

        return count;
    }
}
