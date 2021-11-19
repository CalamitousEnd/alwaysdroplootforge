package com.calamitous_end.alwaysdroplootforge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

//Code Cleanup

@Mod(AlwaysDropLoot.MOD_ID)
public class AlwaysDropLoot {
    public static final String MOD_ID = "alwaysdroplootforge";

    public AlwaysDropLoot() {

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "alwaysdroploot-common.toml");

        MinecraftForge.EVENT_BUS.register(this);

    }

}