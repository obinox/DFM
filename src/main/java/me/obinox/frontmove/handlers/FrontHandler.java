package me.obinox.frontmove.handlers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import me.obinox.frontmove.FrontMove;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class FrontHandler implements Listener {
    public FrontHandler(FrontMove plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onMoveFront(PlayerMoveEvent PME){
        Player p = PME.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE){
    //        World w = p.getWorld();
//            Vector moving = PME.getFrom().clone().subtract(PME.getTo()).toVector().multiply(-1);
//            Vector looking = p.getEyeLocation().getDirection();
//            Vector diff = moving.clone().subtract(looking);
//            Vector movingXZ = new Vector(moving.getX(), 0D, moving.getZ()).normalize();
//            Vector lookingXZ = new Vector(looking.getX(), 0D, looking.getZ()).normalize();
//            if (!Double.isNaN(diff.length()) && Math.toDegrees(movingXZ.clone().angle(lookingXZ)) < 65) {
//                p.getLocation().setDirection(looking);
//                PME.getTo().subtract(lookingXZ.clone().multiply(lookingXZ.dot(moving)));
//            }
            World w = p.getWorld();

            Vector fact = p.getLocation().getDirection();
            Vector move = new Vector(PME.getFrom().getX()-PME.getTo().getX(), 0D, PME.getFrom().getZ()-PME.getTo().getZ()).normalize();
            Vector factor = new Vector(fact.getX(), 0D, fact.getZ()).normalize();
            Bukkit.getLogger().info(move+" "+factor);
            Vector diff = factor.clone().subtract(move);
            if (!Double.isNaN(diff.length()) && Math.toDegrees(move.clone().angle(factor)) < 65) {
                p.getLocation().setDirection(fact);
                Location to = new Location(w, PME.getFrom().getX(), PME.getTo().getY(), PME.getFrom().getZ(), PME.getTo().getYaw(), PME.getTo().getPitch());
                PME.setTo(to);
            }
        }
    }
}
