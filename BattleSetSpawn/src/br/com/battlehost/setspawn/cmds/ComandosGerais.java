package br.com.battlehost.setspawn.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlehost.setspawn.Main;


public class ComandosGerais implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {

		if (cmd.getName().equalsIgnoreCase("setarspawn")){
			Player p = (Player)sender;
			if (args.length == 0){
				if (Main.plugin.getConfig().getBoolean("Desabilitar.SetarSpawn")) {
					p.sendMessage("§cA utilização deste comando foi desabilitado.");
					return true;
				}
				if (p.hasPermission("battlesetspawn.setar")){
					p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SetouSpawn").replace("&", "§"));
					p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockX(), p.getLocation().getBlockZ());
				} else {
					p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§"));
					
				}
				return true;
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			Player p = (Player)sender;
			if (Main.plugin.getConfig().getBoolean("Desabilitar.Spawn")) {
				p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.Desabilitado").replace("&", "§"));
				return true;
			}
			p.teleport(p.getWorld().getSpawnLocation());
		}
		return false;
		}

}
