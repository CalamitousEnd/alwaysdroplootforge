package com.calamitous_end.alwaysdroplootforge.config;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);
    public static final ForgeConfigSpec spec = BUILDER.build();

    public static class General {
        public final ForgeConfigSpec.ConfigValue<String> lootDropMode;
        public final ForgeConfigSpec.ConfigValue<Double> passiveXpModifier;

        public General(ForgeConfigSpec.Builder builder) {
            builder.push("General");
            lootDropMode = builder
                    .comment("Controls whether the killed_by_player loot condition always passes, regardless of whether the entity was killed by a player.(Accepted values are: 'VANILLA', 'VANILLA_INVERSE', 'ALWAYS_AS_PLAYER, and 'NEVER_AS_PLAYER')")
                    .define("lootDropMode", "ALWAYS_AS_PLAYER");
            passiveXpModifier = builder
                    .comment("Controls the amount of XP dropped when mobs are not killed by a player. The value set is multiplied by the mob's natural XP drop value, and the result is rounded to the nearest integer. Set to 0 to disable passive XP drops.")
                    .defineInRange("passiveXpModifier", 0.5, 0.0, 1.0);
            builder.pop();
        }
    }
}
