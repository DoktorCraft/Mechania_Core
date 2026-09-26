package ch.dok.mechania_core.item;

import ch.dok.mechania_core.Mechania_core;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Mechania_core.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static final DeferredItem<Item> MECHANIUM_INGOT = ITEMS.register("mechanium_ingot",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MECHANIUM_NUGGET = ITEMS.register("mechanium_nugget",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MECHANIUM_SHEET = ITEMS.register("mechanium_sheet",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NEPTUNIUM_INGOT = ITEMS.register("neptunium_ingot",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOWCAKE = ITEMS.register("yellowcake",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLASTED_YELLOWCAKE = ITEMS.register("blasted_yellowcake",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MECHANIUM_CRYSTAL = ITEMS.register("mechanium_crystal",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MECHANIUM_FRAGMENT = ITEMS.register("mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURE_URANIUM = ITEMS.register("pure_uranium",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> URANIUM_HEXAFLOURITE = ITEMS.register("uranium_hexaflourite",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_MECHANIUM_CRYSTAL = ITEMS.register("raw_mechanium_crystal",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLUTONIUM_INGOT = ITEMS.register("plutonium_ingot",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> URANINIT = ITEMS.register("uraninit",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRUSHED_URANINIT = ITEMS.register("crushed_uraninit",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PALE_EYE = ITEMS.register("pale_eye",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ARCANEAL_MECHANIUM_FRAGMENT = ITEMS.register("arcaneal_mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BIOLOGICAL_MECHANIUM_FRAGMENT = ITEMS.register("biological_mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHEMICAL_MECHANIUM_FRAGMENT = ITEMS.register("chemical_mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIMENSIONAL_MECHANIUM_FRAGMENT = ITEMS.register("dimensional_mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ELECTRICAL_MECHANIUM_FRAGMENT = ITEMS.register("electrical_mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MECHANICAL_MECHANIUM_FRAGMENT = ITEMS.register("mechanical_mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SUBTERRESTIAL_MECHANIUM_FRAGMENT = ITEMS.register("subterrestial_mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SYNTHETIC_MECHANIUM_FRAGMENT = ITEMS.register("synthetic_mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TERRESTIAL_MECHANIUM_FRAGMENT = ITEMS.register("terrestial_mechanium_fragment",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OMINOUS_CAVE_TABLET = ITEMS.register("ominous_cave_tablet",
            ()-> new Item(new Item.Properties()));

}
