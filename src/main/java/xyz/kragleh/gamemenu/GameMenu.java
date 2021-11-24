package xyz.kragleh.gamemenu;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.kragleh.gamemenu.Commands.ItemReload;
import xyz.kragleh.gamemenu.Events.*;

/** Great job! If your not kragleh and you can see the code! Want free nitro? Dm me for one! Discord: kragleh#4433 **/

public final class GameMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        // Create new config file.
        this.saveDefaultConfig();

        // Create reload command.
        this.getCommand("itemreload").setExecutor(new ItemReload());

        // Register events.
        getServer().getPluginManager().registerEvents(new onPlayerDrop(), this);
        getServer().getPluginManager().registerEvents(new onJoinServer(), this);
        getServer().getPluginManager().registerEvents(new onItemClick(), this);
        getServer().getPluginManager().registerEvents(new onItemSwap(), this);
        getServer().getPluginManager().registerEvents(new onPlayerRespawn(), this);
        getServer().getPluginManager().registerEvents(new onInvClick(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        // None :´)
    }
}
