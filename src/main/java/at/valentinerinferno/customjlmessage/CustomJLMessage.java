package at.valentinerinferno.customjlmessage;

import at.valentinerinferno.customjlmessage.events.PlayerJoin;
import at.valentinerinferno.customjlmessage.events.PlayerLeave;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomJLMessage extends JavaPlugin {

    public static Chat chat = null;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoin(getConfig().getString("joinMessage")), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(getConfig().getString("leaveMessage")), this);

        setupChat();

    }

    private boolean setupChat(){
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
}
