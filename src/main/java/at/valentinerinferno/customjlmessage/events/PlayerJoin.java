package at.valentinerinferno.customjlmessage.events;

import at.valentinerinferno.customjlmessage.CustomJLMessage;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private String message;

    public PlayerJoin(String message) {
        this.message = message;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String msg = message;
        String rank = CustomJLMessage.chat.getPlayerPrefix(e.getPlayer());

        msg = msg.replaceAll("player", e.getPlayer().getDisplayName());
        msg = msg.replaceAll("group", rank);
        msg = msg.replace("%", "");
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        e.setJoinMessage(msg);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
