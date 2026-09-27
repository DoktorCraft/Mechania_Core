package ch.dok.mechania_core.sound;

import ch.dok.mechania_core.Mechania_core;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Mechania_core.MODID);

    public static final Supplier<SoundEvent> HDF_DOK = registerSoundEvent("hdf_dok");
    public static final Supplier<SoundEvent> LACHSI_PLUSH = registerSoundEvent("lachsi_plush");
    public static final Supplier<SoundEvent> METE_PLUSH = registerSoundEvent("mete_plush");
    public static final Supplier<SoundEvent> DOK_PLUSH = registerSoundEvent("dok_plush");
    public static final Supplier<SoundEvent> BIEN_PLUSH = registerSoundEvent("bien_plush");
    public static final Supplier<SoundEvent> MATTI_PLUSH = registerSoundEvent("matti_plush");
    public static final Supplier<SoundEvent> SODOG_PLUSH = registerSoundEvent("sodog_plush");



    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Mechania_core.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}