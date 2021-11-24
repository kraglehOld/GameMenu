package xyz.kragleh.gamemenu.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import xyz.kragleh.gamemenu.GameMenu;

import java.util.ArrayList;
import java.util.List;

/** Great job! If your not kragleh and you can see the code! Want free nitro? Dm me for one! Discord: kragleh#4433 **/

public class onJoinServer implements Listener {

    Plugin plugin = GameMenu.getPlugin(GameMenu.class);

    @EventHandler
    public void onJoinServer(PlayerJoinEvent e) {
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
