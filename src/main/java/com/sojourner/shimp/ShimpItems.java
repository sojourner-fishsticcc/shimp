package com.sojourner.shimp;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ShimpItems {
    //Create DeferredRegister for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Shimp.MODID);


    //Register Items //this is the bit that actually makes items shithead
    public static final RegistryObject<Item> SHRIMP = ITEMS.register(
            "shrimp",
            () -> new Item(new Item.Properties()));


    //Registration methods
    static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    //add items into tabs!
    public static void addItemsToTabs(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(new ItemStack(SHRIMP.get()));
            event.accept(new ItemStack(ShimpBlocks.SHRIMP_BLOCK.get().asItem()));
        }
    }
}
