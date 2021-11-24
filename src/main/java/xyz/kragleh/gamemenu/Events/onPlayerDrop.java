package xyz.kragleh.gamemenu.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.Plugin;
import xyz.kragleh.gamemenu.GameMenu;

public class onPlayerDrop implements Listener {

    Plugin plugin = GameMenu.getPlugin(GameMenu.class);

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().hasItemMeta() && e.getItemDrop().getItemStack().getItemMeta().hasLore() && e.getItemDrop().getItemStack().getItemMeta().getDisplayName() == plugin.getConfig().getString("Item Name")) {
            e.setCancelled(true);
            System.out.println("Player drop works!");
        }
    }

}
