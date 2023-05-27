
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lolipickaxe.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.lolipickaxe.item.LoliPickaxeItem;
import net.mcreator.lolipickaxe.item.DeathItem;
import net.mcreator.lolipickaxe.LolipickaxeMod;

public class LolipickaxeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, LolipickaxeMod.MODID);
	public static final RegistryObject<Item> LOLI_ENTITY_SPAWN_EGG = REGISTRY.register("loli_entity_spawn_egg",
			() -> new ForgeSpawnEggItem(LolipickaxeModEntities.LOLI_ENTITY, -1, -16777216, new Item.Properties().tab(LolipickaxeModTabs.TAB_LOLI_PICKAXE_TAB)));
	public static final RegistryObject<Item> LOLI_PICKAXE = REGISTRY.register("loli_pickaxe", () -> new LoliPickaxeItem());
	public static final RegistryObject<Item> DEATH = REGISTRY.register("death", () -> new DeathItem());
}
