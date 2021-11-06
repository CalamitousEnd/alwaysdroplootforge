package com.calamitous_end.alwaysdroplootforge;

import com.calamitous_end.alwaysdroplootforge.config.ConfigHandler;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(AlwaysDropLoot.MOD_ID)
public class AlwaysDropLoot {
    public static final String MOD_ID = "alwaysdroplootforge";
    private static final Logger LOGGER = LogManager.getLogger();
    public static AlwaysDropLoot instance;

    public AlwaysDropLoot() {
        instance = this;

        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::loadComplete);
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHandler.spec);

    }

    private void loadComplete(final FMLLoadCompleteEvent event) {
        LOGGER.info("LOAD COMPLETE");
    }
}