package me.wouter.antiminechat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Plugin pl;
	
	public void onEnable() { 
		pl = this;
		
		getConfig().addDefault("Minechat.Kick", false);
		getConfig().addDefault("Minechat.Message", true);
		getConfig().addDefault("PickaxeChat.Kick", false);
		getConfig().addDefault("PickaxeChat.Message", true);
		getConfig().addDefault("MovementNeededToChat", true);
		getConfig().addDefault("KickMessage", "&cPlease stop using mobile chat apps.");
		getConfig().addDefault("WarnMessage", "&cPlease stop using mobile chat apps.");
		getConfig().addDefault("MoveMessage", "&cYou need to move if you want to talk.");
		getConfig().options().copyDefaults(true);
        	
		saveConfig();
		
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
		Bukkit.getPluginManager().registerEvents(new Movement(), this);
	}
}
