package br.com.battlehost.setspawn;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.battlehost.setspawn.cmds.ComandosGerais;
import br.com.battlehost.setspawn.cmds.EventosGerais;


public class Main extends JavaPlugin implements Listener{
	
	public static Main getInstance() {
		return instance;
		
	}
	  public static Plugin getPlugin()
	  {
	    return plugin;
	  }
	
	public void onEnable() {
		Data();
}
	
		public void onDisable() {
	quitmessage();
	}

		
	
	public void Comandos() {
		getCommand("setarspawn").setExecutor(new ComandosGerais());
		getCommand("spawn").setExecutor(new ComandosGerais());
	}
	
	public void eventos() {
	    Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new EventosGerais(), this);
	}
	
	public void joinmessage() {
		Bukkit.getConsoleSender().sendMessage("§a§l(BattleHostSetSpawn) §7§oPlugin habilitado!");
		Bukkit.getConsoleSender().sendMessage("§a§l(BattleHostSetSpawn) §7§oFeito por LuccasZambiasi.");
	}
	
	public void quitmessage() {
		Bukkit.getConsoleSender().sendMessage("§a§l(BattleHostSetSpawn) §7§oPlugin desabilitado!");
		Bukkit.getConsoleSender().sendMessage("§a§l(BattleHostSetSpawn) §7§oFeito por LuccasZambiasi.");
	}
	
	
	  public static Main instance;	
	  public static Plugin plugin; 
		  public static Plugin pl;
		  
			public void Data() {
				Comandos();
				eventos();
				joinmessage();
				
			    plugin = this;
			    instance = this;
			    pl = this;
			    saveDefaultConfig();
			}
	  
}