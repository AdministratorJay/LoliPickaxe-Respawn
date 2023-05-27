package net.mcreator.lolipickaxe.mixins;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.Container;
import net.minecraft.client.Minecraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;

import java.util.function.Predicate;

@Mixin(Inventory.class)
public abstract class IMixin {
	@Inject(method = "dropAll", at = @At("HEAD"), cancellable = true)
	private void ondropAll(CallbackInfo ci) {
		Entity entity = Minecraft.getInstance().getCameraEntity();
    	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
				ci.cancel();
	 	}
	}

	@Inject(method = "clearOrCountMatchingItems", at = @At("HEAD"), cancellable = true)
	private void clearOrCountMatchingItems(Predicate<ItemStack> predicate, int i, Container container, CallbackInfoReturnable cir) {
    	Entity entity = Minecraft.getInstance().getCameraEntity();
    	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
            cir.cancel();
    	}
	}

	@Inject(method = "clearContent", at = @At("HEAD"), cancellable = true)
	private void onclearContent(CallbackInfo ci) {
		Entity entity = Minecraft.getInstance().getCameraEntity();
    	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false || entity instanceof LoliEntityEntity || entity.getPersistentData().getBoolean("lolidefense")) {
				ci.cancel();
	 	}
	}
}