package pl.dcrft.dragonShopAnnouncer;

import com.velocitypowered.api.command.SimpleCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class ShopAnnounceCommand implements SimpleCommand {
    private static String prefix = "&e&lDragon&6&lCraft &e» ";

    @Override
    public void execute(final Invocation invocation) {
        String[] args = invocation.arguments();

        if(args.length < 2) return;

        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; ++i) sb.append(args[i]).append(" ");
        final String allArgs = sb.toString().trim();

        String player = args[0];
        String item = allArgs;

        Component message = LegacyComponentSerializer.legacyAmpersand().deserialize(
                prefix + "&3Gracz &b" + player + " &3zakupił &b" + item + "&3!" + "\n"
                + "&e» &3Dziękujemy za wsparcie!" + "\n"
                + "&e» &6Smocze jaja &bdostępne od &61zł&b!" + "\n"
                + "&e» &bSprawdź ofertę na &6DCRFT.PL &c❤"
        );

        DragonShopAnnouncer.getInstance().getProxy().sendMessage(message);
    }

    public boolean hasPermission(final Invocation invocation) {
        return invocation.source().hasPermission("dcshop.use");
    }

}
