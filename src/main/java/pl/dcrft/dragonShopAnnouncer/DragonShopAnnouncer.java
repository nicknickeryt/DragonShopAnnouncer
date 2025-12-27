package pl.dcrft.dragonShopAnnouncer;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

@Plugin(id = "dragonshopannouncer", name = "DragonShopAnnouncer", version = "1.0-SNAPSHOT", description = "Stats manager for DragonCraft", url = "DCRFT.PL", authors = {"NickNickerYT"})
public class DragonShopAnnouncer {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }
}
