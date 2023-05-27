package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.lolipickaxe.network.LolipickaxeModVariables;
import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;
import net.mcreator.lolipickaxe.Loli;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class TickAutoAttackProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		MinecraftForge.EVENT_BUS.start();
		if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).AT) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
							new AABB(_center, _center).inflate(((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).AD2) / 2d), e -> true).stream()
							.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
							if (!(entityiterator instanceof LoliEntityEntity)) {
								if (!entityiterator.getPersistentData().getBoolean("lolidefense")) {
									Loli.KillEntity(entityiterator);
									entityiterator.getPersistentData().putBoolean("lolidead", (true));
								}
							}
						}
					}
				}
			}
		}
	}
}
