package com.calamitous_end.alwaysdroplootforge.mixin;

import com.calamitous_end.alwaysdroplootforge.config.ConfigHandler;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

    @Mixin(LivingEntity.class)
    public class LivingEntityMixin {

        @Shadow
        protected int lastHurtByPlayerTime;

        @Inject(
                at = @At("RETURN"),
                method = "isAlwaysExperienceDropper",
                cancellable = true
        )
        private void alwaysDropXp(CallbackInfoReturnable<Boolean> cir) {
            var enabled =
                    ConfigHandler.GENERAL.alwaysDropXp.get();
            if (enabled) {
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
                        ConfigHandler.GENERAL.passiveXpModifier.get();

                return (int) Math.round(originalXpAmount * modifier);
            } else {
                return originalXpAmount;
            }
        }
    }