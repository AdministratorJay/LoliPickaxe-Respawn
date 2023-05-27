package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.lolipickaxe.init.LolipickaxeModItems;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class DropLoliPickaxeProcedure {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onItemToss(ItemTossEvent event) {
		execute(event, event.getPlayer().level, event.getEntity().getItem());
	}

	public static void execute(LevelAccessor world, ItemStack itemstack) {
		execute(null, world, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, ItemStack itemstack) {
		MinecraftForge.EVENT_BUS.start();
		if (itemstack.getItem() == LolipickaxeModItems.LOLI_PICKAXE.get()) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((itemstack.getOrCreateTag().getString("haver")).equals(entityiterator.getDisplayName().getString())) {
					if (entityiterator instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
