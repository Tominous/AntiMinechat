package me.wouter.antiminechat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Movement implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (e.getTo().getBlockX() > e.getFrom().getBlockX() || e.getTo().getBlockX() < e.getFrom().getBlockX()
				|| e.getTo().getBlockZ() > e.getFrom().getBlockZ() || e.getTo().getBlockZ() < e.getFrom().getBlockZ()) {
			if (PunishmentManager.hasNotMoved.contains(e.getPlayer())) {
				PunishmentManager.hasNotMoved.remove(e.getPlayer());
			}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		PunishmentManager.hasNotMoved.add(e.getPlayer());
	}
}
