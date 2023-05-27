package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.lolipickaxe.network.LolipickaxeModVariables;
import net.mcreator.lolipickaxe.init.LolipickaxeModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BreakBlockProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double az = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LolipickaxeModItems.LOLI_PICKAXE.get()
				&& (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD == 1) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() instanceof LiquidBlock) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
							((world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getBlock() instanceof LiquidBlock _liquid ? new ItemStack(_liquid.getFluid().getBucket()) : ItemStack.EMPTY));
					entityToSpawn.setPickUpDelay(0);
					_level.addFreshEntity(entityToSpawn);
				}
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof Level _level)
					_level.updateNeighborsAt(new BlockPos(x, y, z), _level.getBlockState(new BlockPos(x, y, z)).getBlock());
			}
			if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BT) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock())));
					entityToSpawn.setPickUpDelay(0);
					_level.addFreshEntity(entityToSpawn);
				}
				world.destroyBlock(new BlockPos(x, y, z), false);
			} else {
				{
					BlockPos _pos = new BlockPos(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "tp @e[type=item] @s");
				}
			}
		} else {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LolipickaxeModItems.LOLI_PICKAXE.get()) {
				az = 0 - (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD / 2;
				sx = az;
				for (int index0 = 0; index0 < (int) ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD); index0++) {
					sy = az;
					for (int index1 = 0; index1 < (int) ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD); index1++) {
						sz = az;
						for (int index2 = 0; index2 < (int) ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BD); index2++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() instanceof LiquidBlock) {
								if (world instanceof Level _level && !_level.isClientSide()) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
											((world.getFluidState(new BlockPos(x + sx, y + sy, z + sz)).createLegacyBlock()).getBlock() instanceof LiquidBlock _liquid ? new ItemStack(_liquid.getFluid().getBucket()) : ItemStack.EMPTY));
									entityToSpawn.setPickUpDelay(0);
									_level.addFreshEntity(entityToSpawn);
								}
								world.setBlock(new BlockPos(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof Level _level)
									_level.updateNeighborsAt(new BlockPos(x + sx, y + sy, z + sz), _level.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).getBlock());
							}
							if ((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BT) {
								if (world instanceof Level _level && !_level.isClientSide()) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock())));
									entityToSpawn.setPickUpDelay(0);
									_level.addFreshEntity(entityToSpawn);
								}
								world.destroyBlock(new BlockPos(x + sx, y + sy, z + sz), false);
							} else {
								{
									BlockPos _pos = new BlockPos(x + sx, y + sy, z + sz);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
											_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "tp @e[type=item] @s");
								}
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			}
		}
	}
}
