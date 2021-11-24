package xyz.kragleh.gamemenu.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import xyz.kragleh.gamemenu.GameMenu;

import java.util.ArrayList;
import java.util.List;

/** Great job! If your not kragleh and you can see the code! Want free nitro? Dm me for one! Discord: kragleh#4433 **/

public class ItemReload implements CommandExecutor {

    Plugin plugin = GameMenu.getPlugin(GameMenu.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("itemmenu.reload")) {

            plugin.reloadConfig();

            System.out.println("Config reloaded!");

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

            for(Player players : Bukkit.getOnlinePlayers()) {
                players.getInventory().setItem(8, item);
            }

        } else {
            System.out.println("Config wasnt reloaded!");
        }
        return true;
    }

}
