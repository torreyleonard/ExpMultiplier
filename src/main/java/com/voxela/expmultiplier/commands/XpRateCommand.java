package com.voxela.expmultiplier.commands;

import com.voxela.expmultiplier.ExpMultiplier;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

public class XpRateCommand implements CommandExecutor {

	private String MESSAGE_HEADER = ChatColor.GOLD + "ExpMultiplier" + ChatColor.DARK_GRAY + " | " + ChatColor.GRAY + "Version " + ExpMultiplier.version;

	public XpRateCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 1 && (sender.isOp() || sender.hasPermission(new Permission("voxela.xprate.admin")))) {
			try {
				ExpMultiplier.multiplier = Double.parseDouble(args[0]);
				sender.sendMessage(this.MESSAGE_HEADER);
				sender.sendMessage(ChatColor.DARK_AQUA + "Set experience multiplier to " + ChatColor.GREEN + ExpMultiplier.multiplier);
				return true;
			} catch (NumberFormatException e) {
				this.sendHelpMessage(sender);
				return true;
			}
		}
		this.sendHelpMessage(sender);
		return true;
	}

	private void sendHelpMessage(CommandSender sender) {
		sender.sendMessage(this.MESSAGE_HEADER);
		sender.sendMessage(ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "Current multiplier: " + ChatColor.GREEN + ExpMultiplier.multiplier);
		sender.sendMessage(ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "Usage: " + ChatColor.DARK_AQUA + "/xprate [multiple]");
	}

}
