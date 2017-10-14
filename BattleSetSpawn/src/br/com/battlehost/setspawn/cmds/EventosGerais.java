package br.com.battlehost.setspawn.cmds;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import br.com.battlehost.setspawn.Main;

public class EventosGerais implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (Main.plugin.getConfig().getBoolean("Utilizar.TeleportJoin")) {
			return;
		}
		p.teleport(p.getWorld().getSpawnLocation());
	}

}
