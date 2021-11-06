package com.calamitous_end.alwaysdroplootforge.mixin;

import com.calamitous_end.alwaysdroplootforge.config.ConfigHandler;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LootItemKilledByPlayerCondition.class)
public class KilledByPlayerLootConditionMixin {

  @Inject(
          at = @At("RETURN"),
          method = "test(Lnet/minecraft/world/level/storage/loot/LootContext;)Z",
          cancellable = true
  )
  private void lootDropMode(LootContext lootContext, CallbackInfoReturnable<Boolean> cir) {
    switch (ConfigHandler.GENERAL.lootDropMode.get()) {
      case "VANILLA":
        break;
      case "VANILLA_INVERSE":
        cir.setReturnValue(!cir.getReturnValue());
        break;
      case "ALWAYS_AS_PLAYER":
        cir.setReturnValue(true);
        break;
      case "NEVER_AS_PLAYER":
        cir.setReturnValue(false);
        break;
    }
  }
}


