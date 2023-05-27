package net.mcreator.lolipickaxe.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SetGodProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				entityiterator.getPersistentData().putBoolean("lolidefense", (BoolArgumentType.getBool(arguments, "value")));
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal(("\u00A74\u8BBE\u7F6E\u00A7r\u4E86"
								+ (entityiterator.getDisplayName().getString() + "" + ("\u7684" + ("'\u00A7e\u795E\u00A7r'\u7684\u503C\u4E3A\uFF1A" + entityiterator.getPersistentData().getBoolean("lolidefense")))))), false);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
