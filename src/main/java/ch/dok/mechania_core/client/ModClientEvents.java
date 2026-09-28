package ch.dok.mechania_core.client;

import ch.dok.mechania_core.Mechania_core;
import ch.dok.mechania_core.block.custom.PlushBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = Mechania_core.MODID, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        PlushBlock.cleanupActiveSounds();
    }
}
