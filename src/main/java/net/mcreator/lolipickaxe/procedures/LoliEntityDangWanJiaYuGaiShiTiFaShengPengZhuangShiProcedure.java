package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;
import net.mcreator.lolipickaxe.Loli;

public class LoliEntityDangWanJiaYuGaiShiTiFaShengPengZhuangShiProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (!(sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
			if (!(sourceentity instanceof LoliEntityEntity)) {
				if (!sourceentity.getPersistentData().getBoolean("lolidefense")) {
					MinecraftForge.EVENT_BUS.start();
					Loli.SetDead(sourceentity);
					sourceentity.getPersistentData().putBoolean("lolidead", (true));
				}
			}
		}
	}
}
