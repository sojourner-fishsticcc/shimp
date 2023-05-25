package com.sojourner.shimp;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ShimpBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Shimp.MODID);

    //register block!
    public static final RegistryObject<Block> SHRIMP_BLOCK = register("shrimp_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.FROGLIGHT, MaterialColor.COLOR_PINK)
                    .sound(SoundType.SLIME_BLOCK)));

    //registration methods
    static void register(IEventBus bus) {BLOCKS.register(bus);
    }
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = BLOCKS.register(name, block);
        ShimpItems.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties()));
        return ret;
    }
}