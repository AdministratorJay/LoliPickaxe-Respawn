
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lolipickaxe.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class LolipickaxeModTabs {
	public static CreativeModeTab TAB_LOLI_PICKAXE_TAB;

	public static void load() {
		TAB_LOLI_PICKAXE_TAB = new CreativeModeTab("tabloli_pickaxe_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(LolipickaxeModItems.LOLI_PICKAXE.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
