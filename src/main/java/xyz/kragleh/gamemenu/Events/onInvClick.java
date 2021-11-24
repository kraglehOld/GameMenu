package xyz.kragleh.gamemenu.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class onInvClick implements Listener {

    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        if (e.getSlot() == 8 && e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasLore()) {
            e.setCancelled(true);
        }
    }

}
