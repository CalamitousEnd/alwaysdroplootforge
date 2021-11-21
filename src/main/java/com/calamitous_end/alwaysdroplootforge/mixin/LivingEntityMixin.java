package com.calamitous_end.alwaysdroplootforge.mixin;

import com.calamitous_end.alwaysdroplootforge.Config;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {


    @Shadow
    protected int lastHurtByPlayerTime;

    @Inject(
            at = @At("RETURN"),
            method = "isAlwaysExperienceDropper",
            cancellable = true
    )
    private void alwaysdropxp(CallbackInfoReturnable<Boolean> cir) {
            if (Config.PASSIVE_XP_MULT.get() != 0.0) {
                cir.setReturnValue(true);
            }
    }

    @ModifyArg(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/ExperienceOrb;award(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/phys/Vec3;I)V"
            ),
            method = "dropExperience",
            index = 2
    )
    private int adjustXpAmount(int originalXpAmount) {
        if (this.lastHurtByPlayerTime <= 0) {
            var modifier =
                    Config.PASSIVE_XP_MULT.get();

            return (int) Math.round(originalXpAmount * modifier);
        } else {
            return originalXpAmount;
        }

    }
}


//TODO: Implement checks for valid LivingEntities in Config.MONSTER_LIST
