package net.mcreator.lolipickaxe.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.lolipickaxe.Loli;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class StartattackpProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				Loli.KillEntity(entityiterator);
				entityiterator.getPersistentData().putBoolean("lolidead", (true));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
