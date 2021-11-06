package com.calamitous_end.alwaysdroplootforge.config;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);
    public static final ForgeConfigSpec spec = BUILDER.build();

    public static class General {

        public final ForgeConfigSpec.ConfigValue<Boolean> alwaysDropXp;
        public final ForgeConfigSpec.ConfigValue<Double> passiveXpModifier;
        public final ForgeConfigSpec.ConfigValue<String> lootDropMode;

        public General(ForgeConfigSpec.Builder builder) {
            builder.push("General");
            alwaysDropXp = builder
                    .comment("Controls whether all mobs drop XP when killed, regardless of whether a player killed them.")
                    .define("alwaysDropXp", true);
            passiveXpModifier = builder
                    .comment("Controls the amount of XP dropped when mobs are not killed by a player. Only applies when alwaysDropXp is true. The value set is multiplied by the mob's natural XP drop value, and the result is rounded to the nearest integer.")
                    .defineInRange("passiveXpModifier", 0.5, 0, 1.0);
            lootDropMode = builder
                    .comment("Controls whether the killed_by_player loot condition always passes, regardless of whether the entity was killed by a player.(Accepted values are: 'VANILLA', 'VANILLA_INVERSE', 'ALWAYS_AS_PLAYER, and 'NEVER_AS_PLAYER')")
                    .define("lootDropMode", "ALWAYS_AS_PLAYER");
            builder.pop();
        }
    }
}
