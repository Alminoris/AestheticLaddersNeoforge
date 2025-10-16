package net.alminoris.aestheticladders.item;

import net.alminoris.aestheticladders.AestheticLadders;
import net.alminoris.aestheticladders.util.helper.BlockSetsHelper;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(AestheticLadders.MOD_ID);

    public static final Dictionary<String, DeferredItem<Item>> WOODEN_STICKS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerItem(name+"_stick", () -> new Item(new Item.Properties())));
        }
    }};

    private static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> item)
    {
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}