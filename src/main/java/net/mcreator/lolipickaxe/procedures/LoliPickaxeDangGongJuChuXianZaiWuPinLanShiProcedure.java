package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class LoliPickaxeDangGongJuChuXianZaiWuPinLanShiProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		MinecraftForge.EVENT_BUS.start();
		itemstack.getOrCreateTag().putString("haver", (entity.getDisplayName().getString()));
	}
}
