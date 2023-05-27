package net.mcreator.lolipickaxe.mixins;

import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;

@Mixin(LivingEntity.class)
public class LMixin {
    @Inject(method = "die", at = @At("HEAD"), cancellable = true)
	private void onDie(DamageSource source, CallbackInfo ci) {
    	LivingEntity livingEntity = (LivingEntity) (Object) this;
    	Entity entity = (Entity) livingEntity;
    	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
        	ci.cancel();
    	} 
	}
	
	@Inject(method = "getHealth", at = @At("RETURN"), cancellable = true)
    private void modifyHealth(CallbackInfoReturnable<Float> cir) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Entity entity = (Entity) livingEntity;
        if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity.getPersistentData().getBoolean("lolidefense")) {
			cir.setReturnValue(20f);
		} else if (entity.getPersistentData().getBoolean("lolidead")) {
			cir.setReturnValue(0f);
		} else if (entity instanceof LoliEntityEntity) {
			cir.setReturnValue(2147483647f);
		}
    }

    @Inject(method = "getMaxHealth", at = @At("RETURN"), cancellable = true)
    private void modifyMaxHealth(CallbackInfoReturnable<Float> cir) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        if (livingEntity == null) {
        	return;
        }
        Entity entity = (Entity) livingEntity;
        if (entity == null) {
        	return;
        }
        if (entity instanceof Player p) {
        	if (p.getInventory() != null && !p.getInventory().isEmpty()) {
        		if (p.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get()))) {
					cir.setReturnValue(20f);
			}
        }
        if (entity instanceof LoliEntityEntity) {
        	cir.setReturnValue(2147483647f);
        }
        if (entity.getPersistentData().getBoolean("lolidead")) {
			cir.setReturnValue(0f);
		}
		if (entity.getPersistentData().getBoolean("lolidefense")) {
			cir.setReturnValue(20f);
		}
		}
    }

    @Inject(method = "isDeadOrDying", at = @At("HEAD"), cancellable = true)
    private void isDeadOrDying(CallbackInfoReturnable<Boolean> ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Entity entity = (Entity) livingEntity;
        if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
			ci.setReturnValue(false);
		} else if (entity.getPersistentData().getBoolean("lolidead")) {
			ci.setReturnValue(true);
		}
    }

    @Inject(method = "isAlive", at = @At("HEAD"), cancellable = true)
    private void isAlive(CallbackInfoReturnable<Boolean> ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Entity entity = (Entity) livingEntity;
        if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
			ci.setReturnValue(true);
		} else if (entity.getPersistentData().getBoolean("lolidead")) {
			ci.setReturnValue(false);
		}
    }
    
    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void hurt(DamageSource d, float f, CallbackInfoReturnable ci) {
    	LivingEntity livingEntity = (LivingEntity) (Object) this;
		Entity entity = (Entity) livingEntity;
    	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
        	ci.cancel();
    	} 
	} 
}