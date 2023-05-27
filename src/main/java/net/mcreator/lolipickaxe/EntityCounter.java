package net.mcreator.lolipickaxe;

import net.minecraft.world.entity.Entity;

import java.util.Iterator;

public class EntityCounter {
	public static String countEntities(Iterable<Entity> entities, Entity excludeEntity) {
    	int count = 0;
    	for (Entity e : entities) {
        	if (e != excludeEntity && !e.getClass().equals(excludeEntity.getClass())) {
            	count++;
        	}
    	}
    	return Integer.toString(count);
	}
}
