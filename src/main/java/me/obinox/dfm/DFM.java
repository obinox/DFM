package me.obinox.dfm;

import me.obinox.dfm.handlers.FrontHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DFM extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("FrontMove able");
        new FrontHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
