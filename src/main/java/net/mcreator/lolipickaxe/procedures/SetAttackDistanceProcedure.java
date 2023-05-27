package net.mcreator.lolipickaxe.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.lolipickaxe.network.LolipickaxeModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetAttackDistanceProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = DoubleArgumentType.getDouble(arguments, "value");
			entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AD = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A74\u8BBE\u7F6E\u00A7r\u4E86'\u00A7e\u653B\u51FB\u8DDD\u79BB\u00A7r'\u7684\u503C\u4E3A\uFF1A"
					+ (((((entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).AD + "x") + ""
							+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).AD) + "x") + ""
							+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).AD))),
					(false));
	}
}
