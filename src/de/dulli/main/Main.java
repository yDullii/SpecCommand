package de.dulli.main;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import de.dulli.main.commands.SpecCMD;

public class Main extends JavaPlugin {
  public static String prefix = "§8[§cSpec§8] §7";
  
  public void onEnable() {
    getCommand("spec").setExecutor((CommandExecutor)new SpecCMD());
  }
}
