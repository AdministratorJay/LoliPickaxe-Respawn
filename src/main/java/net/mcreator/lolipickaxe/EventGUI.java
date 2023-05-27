package net.mcreator.lolipickaxe;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mcreator.lolipickaxe.init.LolipickaxeModItems;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(modid = "lolipickaxe")
public class EventGUI {
    @SubscribeEvent
    public static void onGuiOpen(ScreenEvent event) {
    	Entity entity = Minecraft.getInstance().getCameraEntity();
    	if (entity != null) {
        	if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get())) : false) {
        		if (event.getScreen() instanceof DeathScreen) {
    				event.setCanceled(true);
        		}
			}
    	}
    }
}
