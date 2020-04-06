package com.extracraftx.minecraft.extradetectors;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import com.extracraftx.minecraft.extradetectors.item.Items;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtraDetectors implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "extradetectors";
    public static final String MOD_NAME = "ExtraDetectors";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        Items.registerItems();
        log(Level.INFO, "Initialized");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

    public static Identifier createIdentifier(String name){
        return new Identifier(MOD_ID, name);
    }

}