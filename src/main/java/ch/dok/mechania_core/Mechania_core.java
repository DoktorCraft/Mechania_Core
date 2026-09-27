package ch.dok.mechania_core;

import ch.dok.mechania_core.item.ModCreativeModeTabs;
import ch.dok.mechania_core.sound.ModSounds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import ch.dok.mechania_core.item.ModItem;
import ch.dok.mechania_core.block.ModBlocks;

@Mod(Mechania_core.MODID)
public class Mechania_core {
    public static final String MODID = "mechania_core";

    public Mechania_core(IEventBus modEventBus) {
        ModItem.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModSounds.register(modEventBus);
    }
}
