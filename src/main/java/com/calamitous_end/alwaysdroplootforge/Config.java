package com.calamitous_end.alwaysdroplootforge;
 
import net.minecraftforge.common.ForgeConfigSpec;
 
import java.util.List;
 
public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
 
    public static final ForgeConfigSpec.ConfigValue<String> LOOT_DROP_MODE;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> MONSTER_LIST;
    public static final ForgeConfigSpec.ConfigValue<Double> PASSIVE_XP_MULT;
    public static final ForgeConfigSpec.ConfigValue<String> LIST_MODE;
 
    static {
        BUILDER.push("GENERAL");
 
        LOOT_DROP_MODE = BUILDER.comment("Controls whether the killed_by_player loot condition always passes, regardless of whether the entity was killed by a player.").define("LOOT_DROP_MODE", "ALWAYS_AS_PLAYER");
        PASSIVE_XP_MULT = BUILDER.comment("Controls the amount of XP dropped when mobs are not killed by a player. The value set is multiplied by the mob's natural XP drop value and the result is rounded to the nearest integer. Set to 0 to disable passive XP drops.").defineInRange("PASSIVE_XP_MULT", 1.0, 0.0, 1.0);
        LIST_MODE = BUILDER.comment("This feature has not been implemented yet.").define("LIST_MODE","BLACKLIST");
        MONSTER_LIST = BUILDER.comment("This feature has not been implemented yet.").defineListAllowEmpty(List.of("MONSTER_LIST"), () -> List.of("minecraft:wither, minecraft:ender_dragon"), s -> s instanceof String);
 
        BUILDER.pop();
 
        SPEC = BUILDER.build();
    }
}
