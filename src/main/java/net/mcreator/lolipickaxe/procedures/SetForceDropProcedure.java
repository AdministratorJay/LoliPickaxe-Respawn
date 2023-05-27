package net.mcreator.lolipickaxe.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.lolipickaxe.network.LolipickaxeModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SetForceDropProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = BoolArgumentType.getBool(arguments, "value");
			entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BT = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A74\u8BBE\u7F6E\u00A7r\u4E86'\u00A7e\u5F3A\u5236\u6389\u843D\u00A7r'\u7684\u503C\u4E3A\uFF1A"
					+ (entity.getCapability(LolipickaxeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LolipickaxeModVariables.PlayerVariables())).BT)), (false));
	}
}
