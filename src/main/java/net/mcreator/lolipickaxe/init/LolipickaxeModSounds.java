
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lolipickaxe.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.lolipickaxe.LolipickaxeMod;

public class LolipickaxeModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LolipickaxeMod.MODID);
	public static final RegistryObject<SoundEvent> LOLIPICKAXE_ATTACK = REGISTRY.register("lolipickaxe_attack", () -> new SoundEvent(new ResourceLocation("lolipickaxe", "lolipickaxe_attack")));
}
