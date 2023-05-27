package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.Loli;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TickUpdateDefProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		MinecraftForge.EVENT_BUS.start();
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false) {
			Loli.Defense(entity);
		}
	}
}
