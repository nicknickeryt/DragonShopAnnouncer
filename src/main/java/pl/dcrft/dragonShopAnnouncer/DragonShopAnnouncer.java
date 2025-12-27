package pl.dcrft.dragonShopAnnouncer;

import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandMeta;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(id = "dragonshopannouncer", name = "DragonShopAnnouncer", version = "1.0-SNAPSHOT", description = "Stats manager for DragonCraft", url = "DCRFT.PL", authors = {"NickNickerYT"})
public class DragonShopAnnouncer {
    private final ProxyServer proxy;
    private static DragonShopAnnouncer instance;

    public ProxyServer getProxy() {
        return proxy;
    }

    public static DragonShopAnnouncer getInstance() {
        return instance;
    }

    @Inject
    public DragonShopAnnouncer(ProxyServer proxy) {
        this.proxy = proxy;
        instance = this;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        CommandManager commandManager = proxy.getCommandManager();
        CommandMeta commandMeta = commandManager.metaBuilder("shopannounce")
                .plugin(this)
                .build();

        SimpleCommand commandToRegister = new ShopAnnounceCommand();

        commandManager.register(commandMeta, commandToRegister);
    }
}
