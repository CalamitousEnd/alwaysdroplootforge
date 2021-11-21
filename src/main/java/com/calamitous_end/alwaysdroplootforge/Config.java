package com.calamitous_end.alwaysdroplootforge;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.EnumValue<LIST_MODE_ENUM> LIST_MODE;
    public static final ForgeConfigSpec.EnumValue<LOOT_MODE_ENUM> LOOT_DROP_MODE;

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> MONSTER_LIST;
    public static final ForgeConfigSpec.ConfigValue<Double> PASSIVE_XP_MULT;

    static {
        BUILDER.push("GENERAL");

        LOOT_DROP_MODE = BUILDER.comment("Controls whether the killed_by_player loot condition always passes, regardless of whether the entity was killed by a player. Default Value: ALWAYS_AS_PLAYER").defineEnum("LOOT_DROP_MODE", LOOT_MODE_ENUM.ALWAYS_AS_PLAYER);
        PASSIVE_XP_MULT = BUILDER.comment("Controls the amount of XP dropped when mobs are not killed by a player. The value set is multiplied by the mob's natural XP drop value and the result is rounded to the nearest integer. Set to 0 to disable passive XP drops.").defineInRange("PASSIVE_XP_MULT", 1.0, 0.0, 1.0);
        LIST_MODE = BUILDER.comment("This feature has not been implemented yet. Default Value: false").defineEnum("LIST_MODE", LIST_MODE_ENUM.BLACKLIST);
        MONSTER_LIST = BUILDER.comment("This feature has not been implemented yet.").defineList("MONSTER_LIST", Arrays.asList("minecraft:wither"), entry -> true);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    public enum LIST_MODE_ENUM {
        BLACKLIST,
        WHITELIST
    }

    public enum LOOT_MODE_ENUM {
        ALWAYS_AS_PLAYER,
        VANILLA,
        VANILLA_INVERSE,
        NEVER_AS_PLAYER

    }
}
