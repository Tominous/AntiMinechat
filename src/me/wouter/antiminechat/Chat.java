package me.wouter.antiminechat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if (e.getMessage().toLowerCase().contains("connected with a") && e.getMessage().toLowerCase().contains("using minechat")) {
			e.setCancelled(true);
			PunishmentManager.punish(e.getPlayer(), PunishmentType.MINECHAT);
		}else if (e.getMessage().toLowerCase().contains("connected using") && e.getMessage().toLowerCase().contains("pickaxechat")) {
			PunishmentManager.punish(e.getPlayer(), PunishmentType.PICKAXECHAT);
			e.setCancelled(true);
		}else if (PunishmentManager.hasNotMoved.contains(e.getPlayer())) {
			PunishmentManager.punish(e.getPlayer(), PunishmentType.MOVEMENT);
			e.setCancelled(true);
		}
	}
}
