package ca.sperrer.p0t4t0sandwich.template.forge.listeners;

import ca.sperrer.p0t4t0sandwich.template.forge.ForgeMain;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static ca.sperrer.p0t4t0sandwich.template.common.Utils.runTaskAsync;

public class ForgePlayerLoginListener {
    ForgeMain mod = ForgeMain.getInstance();

    @SubscribeEvent
    public void onPlayerConnect(PlayerEvent.PlayerLoggedInEvent event) {
        runTaskAsync(() -> {
            try {
                // Do stuff
            } catch (Exception e) {
                System.err.println(e);
                e.printStackTrace();
            }
        });
    }
}
