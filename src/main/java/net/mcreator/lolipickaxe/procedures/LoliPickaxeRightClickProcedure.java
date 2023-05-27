package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.lolipickaxe.network.LolipickaxeModVariables;
import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;
import net.mcreator.lolipickaxe.Loli;
import net.mcreator.lolipickaxe.EntityCounter;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class LoliPickaxeRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ad = 0;
		MinecraftForge.EVENT_BUS.start();
		if (entity.isShiftKeyDown()) {
			ad = (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).AD;
			final Vec3 v = new Vec3(x, y, z);
			List<Entity> el = world.getEntitiesOfClass(Entity.class, new AABB(v, v).inflate(ad / 2d), e -> true).stream().sorted(Comparator.comparingDouble(el2 -> el2.distanceToSqr(v))).collect(Collectors.toList());
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal((((("\u653B\u51FB\u4E86" + (((((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).AD + "x") + ""
						+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).AD) + "x") + ""
						+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).AD)) + "\u8303\u56F4\u5185\u7684") + "" + EntityCounter.countEntities(el, entity))
						+ "\u4E2A\u5B9E\u4F53")), (false));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lolipickaxe:lolipickaxe_attack")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lolipickaxe:lolipickaxe_attack")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(ad / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
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
		} else {
			if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD == 1) {
				{
					double _setval = 3;
					entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.BD = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(
							Component.literal(("\u8BBE\u7F6E\u6316\u6398\u8DDD\u79BB\u4E3A\uFF1A" + (((((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD + "x")
									+ "" + (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD) + "x") + ""
									+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD))),
							(false));
			} else {
				if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD == 3) {
					{
						double _setval = 5;
						entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.BD = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component
								.literal(("\u8BBE\u7F6E\u6316\u6398\u8DDD\u79BB\u4E3A\uFF1A" + (((((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD + "x") + ""
										+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD) + "x") + ""
										+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD))),
								(false));
				} else {
					if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD == 5) {
						{
							double _setval = 7;
							entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.BD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(Component
									.literal(("\u8BBE\u7F6E\u6316\u6398\u8DDD\u79BB\u4E3A\uFF1A" + (((((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD + "x")
											+ "" + (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD) + "x") + ""
											+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD))),
									(false));
					} else {
						if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD == 7) {
							{
								double _setval = 9;
								entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.BD = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player _player && !_player.level.isClientSide())
								_player.displayClientMessage(Component.literal(
										("\u8BBE\u7F6E\u6316\u6398\u8DDD\u79BB\u4E3A\uFF1A" + (((((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD + "x") + ""
												+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD) + "x") + ""
												+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD))),
										(false));
						} else {
							if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD == 9) {
								{
									double _setval = 11;
									entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.BD = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player _player && !_player.level.isClientSide())
									_player.displayClientMessage(Component.literal(
											("\u8BBE\u7F6E\u6316\u6398\u8DDD\u79BB\u4E3A\uFF1A" + (((((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD + "x")
													+ "" + (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD) + "x") + ""
													+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD))),
											(false));
							} else {
								if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD == 11) {
									{
										double _setval = 1;
										entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.BD = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal(("\u8BBE\u7F6E\u6316\u6398\u8DDD\u79BB\u4E3A\uFF1A"
												+ (((((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD + "x") + ""
														+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD) + "x") + ""
														+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD))),
												(false));
								} else {
									if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD != 1
											&& (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD != 3
											&& (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD != 5
											&& (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD != 7
											&& (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD != 9
											&& (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD != 11) {
										{
											double _setval = 1;
											entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.BD = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof Player _player && !_player.level.isClientSide())
											_player.displayClientMessage(Component.literal(("\u8BBE\u7F6E\u6316\u6398\u8DDD\u79BB\u4E3A\uFF1A"
													+ (((((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD + "x") + ""
															+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD) + "x") + ""
															+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD))),
													(false));
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
