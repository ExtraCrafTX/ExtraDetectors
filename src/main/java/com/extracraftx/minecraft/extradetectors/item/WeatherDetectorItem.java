package com.extracraftx.minecraft.extradetectors.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class WeatherDetectorItem extends Item{

    public static final float CLEAR = 0;
    public static final float RAIN = 1;
    public static final float SNOW = 2;
    public static final float THUNDER = 3;
    public static final float NETHER = 4;
    public static final float END = 5;

    public WeatherDetectorItem(){
        super(new Settings().group(ItemGroup.TOOLS));
        this.addPropertyGetter(new Identifier("weather"), new ItemPropertyGetter(){
            @Override
            public float call(ItemStack itemStack, World world, LivingEntity livingEntity) {
                Entity entity = livingEntity != null ? livingEntity : itemStack.getFrame();
                if (world == null) {
                    if(entity == null)
                        return 0;
                    world = entity.world;
                }
                if (entity == null) {
                    entity = MinecraftClient.getInstance().player;
                }
                Biome biome = world.getBiome(entity.getBlockPos());
                if(biome.equals(Biomes.NETHER))
                    return NETHER;
                if(biome.equals(Biomes.THE_END) || biome.equals(Biomes.END_BARRENS) || biome.equals(Biomes.END_HIGHLANDS) || biome.equals(Biomes.END_MIDLANDS) || biome.equals(Biomes.SMALL_END_ISLANDS))
                    return END;
                if(!world.isRaining()){
                    return CLEAR;
                }
                switch(biome.getPrecipitation()){
                    case RAIN:
                        if(world.isThundering())
                            return THUNDER;
                        return RAIN;
                    case SNOW:
                        if(world.isThundering())
                            return THUNDER;
                        return SNOW;
                    default:
                        return CLEAR;
                }
            }
        });
    }

}