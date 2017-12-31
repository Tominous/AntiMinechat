package me.wouter.antiminechat;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PunishmentManager {

	public static ArrayList<Player> hasNotMoved = new ArrayList<>();

	public static void punish(final Player p, final PunishmentType type) {
		if (!p.hasPermission("antiminechat.bypass")) {
			Bukkit.getScheduler().runTask(Main.pl, new Runnable() {
				public void run() {
					if (type == PunishmentType.MINECHAT) {
						if (Main.pl.getConfig().getBoolean("Minechat.Kick")) {
							p.kickPlayer(cc(Main.pl.getConfig().getString("KickMessage")));
						}
						if (Main.pl.getConfig().getBoolean("Minechat.Message")) {
							p.sendMessage(cc(Main.pl.getConfig().getString("WarnMessage")));
						}
					} else if (type == PunishmentType.PICKAXECHAT) {
						if (Main.pl.getConfig().getBoolean("PickaxeChat.Kick")) {
							p.kickPlayer(cc(Main.pl.getConfig().getString("KickMessage")));
						}
						if (Main.pl.getConfig().getBoolean("PickaxeChat.Message")) {
							p.sendMessage(cc(Main.pl.getConfig().getString("WarnMessage")));
						}
					} else if (type == PunishmentType.MOVEMENT) {
						if (Main.pl.getConfig().getBoolean("MovementNeededToChat")) {
							p.sendMessage(cc(Main.pl.getConfig().getString("MoveMessage")));
						}
					}
				}
			});
		}
	}

	public static String cc(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
}
