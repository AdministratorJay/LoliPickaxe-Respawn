package net.mcreator.lolipickaxe;

import net.mcreator.lolipickaxe.*;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.network.chat.Component;

import com.google.gson.JsonObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ForgeMod;
import net.minecraft.world.level.entity.EntityInLevelCallback;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

@Mod.EventBusSubscriber
public class Loli {
    public static void Defense(Entity entity) {
    	MinecraftForge.EVENT_BUS.start();
		if (entity == null) {
    		return;
		}
		if (!(entity instanceof LivingEntity)) {
    		return;
		}
		LivingEntity l = (LivingEntity) entity;
		Minecraft mc = Minecraft.getInstance();
    	entity.canUpdate(true);
    	if (entity.isRemoved()) {
    		entity.restoreFrom(entity);
    		entity.onAddedToWorld();
    		entity.revive();
    	}
    	l.setHealth(l.getMaxHealth());
    	((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(20);
    	for (MobEffectInstance effect : l.getActiveEffects()) {
			if (!effect.getEffect().isBeneficial()) {
				l.removeEffect(effect.getEffect());
			}
		}
		l.deathTime = -2;
		l.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 240, 1, (false), (false)));
    	entity.setTicksFrozen(0);
    	entity.setAirSupply(entity.getMaxAirSupply());
    	entity.clearFire();
		if (entity instanceof Player _player) {
			_player.getAbilities().mayfly = true;
			_player.onUpdateAbilities();
			_player.hurtTime = -1;
		}
    }
    
	public static void KillEntity(Entity entity) {
		MinecraftForge.EVENT_BUS.start();
    	DamageSource d = new DamageSource("loli");
    	if (!(entity instanceof LivingEntity)) {
        	entity.remove(Entity.RemovalReason.UNLOADED_TO_CHUNK);
        	return;
    	}
    	LivingEntity li = (LivingEntity) entity;
    	if (li == null) {
        	return;
    	}
    	if (li.isSleeping() && !li.level.isClientSide && !(li instanceof Player)) {
    		li.stopSleeping();
    	}else if (li instanceof Player && li.isSleeping()){
    		Player p = (Player) li;
    		p.stopSleeping();
    	}
    	entity.invulnerableTime = -2;
    	li.invulnerableTime = -2;
    	if (entity instanceof Player) {
    		Player pl = (Player) li;
    		pl.invulnerableTime = -2;
    	}
    	entity.kill();
    	for (int i = 0; i < 100; i++) {
        	li.hurt(d, 3.4028236E34F * i);
        	((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(0);
        	li.setHealth(-2);
    	}
    	if (!li.isDeadOrDying()) {
    		li.die(d);
    	}
    	if (!li.isDeadOrDying()) {
    		entity.setRemoved(Entity.RemovalReason.KILLED);
    		entity.invalidateCaps();
    		li.remove(Entity.RemovalReason.KILLED);
    		if (entity instanceof Player) {
    			Player pl2 = (Player) li;
    			pl2.remove(Entity.RemovalReason.KILLED);
    			pl2.setRemoved(Entity.RemovalReason.KILLED);
    			pl2.invalidateCaps();
    		}
    	}
	}

	public static void RemoveEntity(Entity entity) {
		MinecraftForge.EVENT_BUS.start();
		if (entity == null) {
			return;
		}
		if (!(entity instanceof LivingEntity)) {
			entity.remove(Entity.RemovalReason.UNLOADED_TO_CHUNK);
		}
		if (entity instanceof Player) {
    		Player p = (Player) entity;
    		p.remove(Entity.RemovalReason.UNLOADED_WITH_PLAYER);
    		p.remove(Entity.RemovalReason.UNLOADED_TO_CHUNK);
    		p.setRemoved(Entity.RemovalReason.UNLOADED_WITH_PLAYER);
    		p.setRemoved(Entity.RemovalReason.UNLOADED_TO_CHUNK);
    		p.invalidateCaps();
		}
		if (entity instanceof LivingEntity) {
			LivingEntity l = (LivingEntity) entity;
    		l.remove(Entity.RemovalReason.UNLOADED_TO_CHUNK);
    		l.setRemoved(Entity.RemovalReason.UNLOADED_TO_CHUNK);
    		l.invalidateCaps();
		}
    	entity.setRemoved(Entity.RemovalReason.UNLOADED_TO_CHUNK);
    	entity.invalidateCaps();
	}

	public static void SetDead(Entity entity) {
		MinecraftForge.EVENT_BUS.start();
		if (entity == null) {
			return;
		}
		if (!(entity instanceof LivingEntity)) {
			entity.remove(Entity.RemovalReason.UNLOADED_TO_CHUNK);
		}
		KillEntity(entity);
		entity.getPersistentData().putBoolean("lolidead", (true));
	}

	public static boolean isDead(Entity entity) {
		MinecraftForge.EVENT_BUS.start();
		if (entity == null) {
			LolipickaxeMod.LOGGER.fatal("LoliPickaxeMod Code Error:Entity is empty");
			return false;
		}
		if (!(entity instanceof LivingEntity)) {
			LolipickaxeMod.LOGGER.fatal("LoliPickaxeMod Code Error:Entity is not a LivingEntity");
			return false;
		}
		LivingEntity l = (LivingEntity) entity;
		if (l.isDeadOrDying()) {
			if (!(l.isAlive())) {
				if (l.getHealth() <= 0) {
					if (l.getMaxHealth() <= 0) {
						return true;
					}
				}
			}
		}
		if (!(l.isDeadOrDying())) {
			if (l.isAlive()) {
				if (l.getHealth() > 0) {
					if (l.getMaxHealth() > 0) {
						return false;
					}
				}
			}
		}
		LolipickaxeMod.LOGGER.fatal("LoliPickaxeMod Code Error:An Unknown Error Occurred");
		return false;
	}
}