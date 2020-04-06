package com.extracraftx.minecraft.extradetectors.item;

import com.extracraftx.minecraft.extradetectors.ExtraDetectors;

import org.apache.logging.log4j.Level;

import net.minecraft.util.registry.Registry;

public class Items {

    public static WeatherDetectorItem WEATHER_DETECTOR;

    public static void registerItems(){
        ExtraDetectors.log(Level.INFO, "Registering items");
        WEATHER_DETECTOR = Registry.register(Registry.ITEM, ExtraDetectors.createIdentifier("weather_detector"), new WeatherDetectorItem());
    }

}