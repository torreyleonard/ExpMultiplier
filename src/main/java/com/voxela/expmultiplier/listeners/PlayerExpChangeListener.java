package com.voxela.expmultiplier.listeners;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.voxela.expmultiplier.ExpMultiplier;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerExpChangeListener implements Listener {

	private JavaPlugin plugin;

	public PlayerExpChangeListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerExpChange(PlayerExpChangeEvent event) {
		int amount = event.getAmount();
		if (ExpMultiplier.multiplier > 1) {
			event.setAmount((int) (amount * ExpMultiplier.multiplier));
			Player player = event.getPlayer();
			if (this.plugin.getConfig().getBoolean("showActionBar")) {
				ActionBarAPI.sendActionBar(player, ChatColor.GOLD + "" + ChatColor.BOLD + "SERVER XP EVENT" + ChatColor.GRAY + " | " + ChatColor.AQUA + ChatColor.BOLD + ((int) ExpMultiplier.multiplier) + "x XP");
			}
		}
	}

}
