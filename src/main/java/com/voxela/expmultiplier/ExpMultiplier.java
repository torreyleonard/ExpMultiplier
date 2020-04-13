package com.voxela.expmultiplier;

import com.voxela.expmultiplier.commands.XpRateCommand;
import com.voxela.expmultiplier.listeners.PlayerExpChangeListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExpMultiplier extends JavaPlugin {

	public static double multiplier;
	public static String version;

	@Override
	public void onEnable() {

		getConfig().options().copyDefaults();
		saveDefaultConfig();

		multiplier = getConfig().getDouble("defaultMultiplier");
		version = getDescription().getVersion();

		System.out.println("Started ExpMultiplier with default multiplier of " + multiplier);

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerExpChangeListener(this), this);
		this.getCommand("xprate").setExecutor(new XpRateCommand());

	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

}
