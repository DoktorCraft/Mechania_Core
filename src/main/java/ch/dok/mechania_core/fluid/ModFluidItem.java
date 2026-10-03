package ch.dok.mechania_core.fluid;

import ch.dok.mechania_core.Mechania_core;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluidItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, Mechania_core.MODID);

    public static final DeferredHolder <Item, BucketItem> MOLTEN_MECHANIUM_BUCKET = ITEMS.register("molten_mechanium_bucket",
            ()-> new BucketItem(ModFluid.SOURCE_MOLTEN_MECHANIUM.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder <Item, BucketItem> UNREFINED_MOLTEN_MECHANIUM_BUCKET = ITEMS.register("unrefined_molten_mechanium_bucket",
            ()-> new BucketItem(ModFluid.SOURCE_UNREFINED_MOLTEN_MECHANIUM.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder <Item, BucketItem> MOLTEN_GUNMETAL_BUCKET = ITEMS.register("molten_gunmetal_bucket",
            ()-> new BucketItem(ModFluid.SOURCE_MOLTEN_GUNMETAL.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder <Item, BucketItem> URANIUM_SOLUTION_BUCKET = ITEMS.register("uranium_solution_bucket",
            ()-> new BucketItem(ModFluid.SOURCE_URANIUM_SOLUTION.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder <Item, BucketItem> URANIUM_SLURRY_BUCKET = ITEMS.register("uranium_slurry_bucket",
            ()-> new BucketItem(ModFluid.SOURCE_URANIUM_SLURRY.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}