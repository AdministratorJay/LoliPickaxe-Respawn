package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;
import net.mcreator.lolipickaxe.Loli;

public class LoliPickaxeDangShiTiBeiGongJuJiZhongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
			if (!(entity instanceof LoliEntityEntity)) {
				if (!entity.getPersistentData().getBoolean("lolidefense")) {
					MinecraftForge.EVENT_BUS.start();
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lolipickaxe:lolipickaxe_attack")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lolipickaxe:lolipickaxe_attack")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					Loli.KillEntity(entity);
					entity.getPersistentData().putBoolean("lolidead", (true));
				}
			}
		}
	}
}
