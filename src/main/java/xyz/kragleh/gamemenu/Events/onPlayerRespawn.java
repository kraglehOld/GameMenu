package xyz.kragleh.gamemenu.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import xyz.kragleh.gamemenu.GameMenu;

import java.util.ArrayList;
import java.util.List;

public class onPlayerRespawn implements Listener {

    Plugin plugin = GameMenu.getPlugin(GameMenu.class);

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        if (meta.getLore() != null){
            lore = meta.getLore();
        }
        lore.add(plugin.getConfig().getString("Item Lore"));
        meta.setLore(lore);
        meta.setDisplayName(plugin.getConfig().getString("Item Name"));
        item.setItemMeta(meta);

        p.getInventory().setItem(8, item);
    }

}
