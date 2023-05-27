package net.mcreator.lolipickaxe.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.mcreator.lolipickaxe.entity.LoliEntityEntity;
import net.mcreator.lolipickaxe.Loli;

import java.util.ArrayList;

public class LoliEntityDangShiTiGengXinKeShiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity a = null;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.isAlive()) {
				if (!(entityiterator instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false)) {
					if (!(entityiterator instanceof LoliEntityEntity)) {
						if (!entityiterator.getPersistentData().getBoolean("lolidefense")) {
							{
								Entity _ent = entity;
								_ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
							}
						}
					}
				}
			}
		}
		a = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
		Loli.SetDead(a);
	}
}
