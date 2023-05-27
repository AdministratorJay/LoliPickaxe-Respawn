package net.mcreator.lolipickaxe.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;

import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;

@Mixin(Entity.class)
public class EMixin {
    @Inject(method = "discard", at = @At("HEAD"), cancellable = true)
    private void onDiscard(CallbackInfo ci) {
    	Entity entity = (Entity) (Object) this;
    	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
        	ci.cancel();
    	} 
    }
    
    @Inject(method = "remove", at = @At("HEAD"), cancellable = true)
    private void onRemove(CallbackInfo ci) {
    	Entity entity = (Entity) (Object) this;
    	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
        	ci.cancel();
    	} 
    }

    @Inject(method = "kill", at = @At("HEAD"), cancellable = true)
    private void onkill(CallbackInfo ci) {
    	Entity entity = (Entity) (Object) this;
    	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
        	ci.cancel();
    	} 
	}

    @Inject(method = "setRemoved", at = @At("HEAD"), cancellable = true)
    private void onsetRemoved(Entity.RemovalReason er, CallbackInfo ci) {
    	Entity entity = (Entity) (Object) this;
    	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity.getPersistentData().getBoolean("lolidefense") && !(entity instanceof LoliEntityEntity)) {
        	ci.cancel();
    	} 
    	if (entity instanceof LoliEntityEntity && !(entity.getPersistentData().getBoolean("loliremove"))) {
    		ci.cancel();
    	}
	}
}