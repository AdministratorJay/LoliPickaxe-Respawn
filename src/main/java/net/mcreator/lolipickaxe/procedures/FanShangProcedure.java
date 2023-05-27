package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.lolipickaxe.network.LolipickaxeModVariables;
import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;
import net.mcreator.lolipickaxe.Loli;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FanShangProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		MinecraftForge.EVENT_BUS.start();
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false) {
			if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).FS) {
				if (!(sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
					if (!(sourceentity instanceof LoliEntityEntity)) {
						if (!sourceentity.getPersistentData().getBoolean("lolidefense")) {
							if (!(immediatesourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
								if (!(immediatesourceentity instanceof LoliEntityEntity)) {
									if (!immediatesourceentity.getPersistentData().getBoolean("lolidefense")) {
										Loli.SetDead(sourceentity);
										Loli.SetDead(immediatesourceentity);
									}
								}
							}
						}
					}
				}
			}
		}
		if (sourceentity instanceof LoliEntityEntity) {
			if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
				if (!(entity instanceof LoliEntityEntity)) {
					if (!entity.getPersistentData().getBoolean("lolidefense")) {
						Loli.SetDead(entity);
					}
				}
			}
		}
		if (entity instanceof LoliEntityEntity) {
			if (!(sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
				if (!(sourceentity instanceof LoliEntityEntity)) {
					if (!sourceentity.getPersistentData().getBoolean("lolidefense")) {
						if (!(immediatesourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
							if (!(immediatesourceentity instanceof LoliEntityEntity)) {
								if (!immediatesourceentity.getPersistentData().getBoolean("lolidefense")) {
									Loli.SetDead(sourceentity);
									Loli.SetDead(immediatesourceentity);
								}
							}
						}
					}
				}
			}
		}
	}
}
