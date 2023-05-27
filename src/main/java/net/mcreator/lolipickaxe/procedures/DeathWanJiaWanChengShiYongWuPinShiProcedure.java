package net.mcreator.lolipickaxe.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;
import net.mcreator.lolipickaxe.Loli;

public class DeathWanJiaWanChengShiYongWuPinShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
			if (!(entity instanceof LoliEntityEntity)) {
				if (!entity.getPersistentData().getBoolean("lolidefense")) {
					Loli.SetDead(entity);
				}
			}
		}
	}
}
