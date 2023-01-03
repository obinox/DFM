package me.obinox.dfm.handlers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import me.obinox.dfm.DFM;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class FrontHandler implements Listener {
    public FrontHandler(DFM plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onMoveFront(@NotNull PlayerMoveEvent PME){
        Player p = PME.getPlayer();
        if (p.getGameMode() == GameMode.SURVIVAL){
            Location F = PME.getFrom();
            Location T = PME.getTo();
            Vector move = new Vector(F.getX()-T.getX(), 0D, F.getZ()-T.getZ()).normalize();
            Vector face = p.getLocation().getDirection();
            Vector forward = new Vector(face.getX(), 0D, face.getZ()).normalize();
            Vector diff = move.clone().subtract(forward);
            if (!Double.isNaN(diff.length()) && Math.toDegrees(move.clone().angle(forward)) > 115) {
                PME.setTo(new Location(p.getWorld(), F.getX(), T.getY(), F.getZ(), T.getYaw(), T.getPitch()));
            }
        }
    }
}
