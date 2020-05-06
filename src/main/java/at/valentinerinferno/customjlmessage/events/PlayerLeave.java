package at.valentinerinferno.customjlmessage.events;

import at.valentinerinferno.customjlmessage.CustomJLMessage;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    private String message;

    public PlayerLeave(String message) {
        this.message = message;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        String msg = message;
        String rank = CustomJLMessage.chat.getPlayerPrefix(e.getPlayer());

        msg = msg.replaceAll("player", e.getPlayer().getDisplayName());
        msg = msg.replaceAll("group", rank);
        msg = msg.replace("%", "");
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        e.setQuitMessage(msg);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
