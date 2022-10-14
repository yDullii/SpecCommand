package de.dulli.main.commands;

import de.dulli.main.Main;
import java.util.ArrayList;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SpecCMD implements CommandExecutor, Listener {
  private ArrayList<Player> iswaitingforsup = new ArrayList<>();
  
  public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
    if (s instanceof Player) {
      Player p = (Player)s;
      this.iswaitingforsup.add((Player)s);
      for (Player all : Bukkit.getOnlinePlayers()) {
        if (all.hasPermission("spec.msg")) {
          all.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler §b" + s.getName() + " §7braucht einen §cSpectator");
          all.sendMessage(" ");
          TextComponent msg = new TextComponent();
          msg.setText("§7Teleportiere dich zum §bSpieler");
          msg.setBold(Boolean.valueOf(true));
          msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + s.getName()));
          this.iswaitingforsup.remove(s);
          msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("§7Click to TP")).create()));
          all.spigot().sendMessage((BaseComponent)msg);
        } 
      } 
    } else {
      s.sendMessage(String.valueOf(Main.prefix) + "§cDu bist kein Spieler");
    } 
    return false;
  }
}
