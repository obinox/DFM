package me.obinox.frontmove.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import me.obinox.frontmove.FrontMove;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class FrontHandler implements Listener {
    public FrontHandler(FrontMove plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onMoveFront(PlayerMoveEvent E){
//        @NotNull Player p = E.getPlayer();
        @NotNull Location F = E.getFrom();
        @NotNull Location T = E.getTo();
//        @NotNull Vector dir = T.getDirection();
//        float pitch = T.getPitch();
        float yaw = (T.getYaw() % 360 + 360) % 360;
        double x = F.getX() - T.getX();
        double z = F.getZ() - T.getZ();
        double theta = (Math.toDegrees(Math.atan2(-z,x) - 90) % 360 + 360) % 360;
        E.setCancelled(-90 >= (theta - yaw) || (theta - yaw) >= 90);
//        Bukkit.getLogger().info("(" + yaw+ " / " + pitch + ")");
        Bukkit.getLogger().info("(" + yaw + " / " + theta + ")" + (theta - yaw));
    }
}
