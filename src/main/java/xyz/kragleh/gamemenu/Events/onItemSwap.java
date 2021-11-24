package xyz.kragleh.gamemenu.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.Plugin;
import xyz.kragleh.gamemenu.GameMenu;

public class onItemSwap implements Listener {

    Plugin plugin = GameMenu.getPlugin(GameMenu.class);

    @EventHandler
    public void onPlayerSwapItem(PlayerSwapHandItemsEvent e) {

        if (e.getOffHandItem().hasItemMeta() && e.getOffHandItem().getItemMeta().hasLore() && e.getOffHandItem().getItemMeta().getDisplayName() == plugin.getConfig().getString("Item Name")) {
            e.setCancelled(true);
            System.out.println("Player swap works!");
        }
    }

}
