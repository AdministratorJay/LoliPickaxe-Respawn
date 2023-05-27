
package net.mcreator.lolipickaxe.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.lolipickaxe.procedures.LoliPickaxeMakeItemGlowProcedure;
import net.mcreator.lolipickaxe.procedures.DeathWanJiaWanChengShiYongWuPinShiProcedure;
import net.mcreator.lolipickaxe.init.LolipickaxeModTabs;
import net.mcreator.lolipickaxe.*;

import java.util.List;
import com.google.gson.JsonObject;

public class DeathItem extends Item {
	public DeathItem() {
		super(new Item.Properties().tab(LolipickaxeModTabs.TAB_LOLI_PICKAXE_TAB).stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat()

				.build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return LoliPickaxeMakeItemGlowProcedure.execute(

		);
	}

	@Override
	public Component getName(ItemStack Stack){
    	String g = CaiZi.lightrainbow("Death");
    	JsonObject jsonObject = new JsonObject();
    	jsonObject.addProperty("text", g);
    	return Component.Serializer.fromJson(jsonObject.toString());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal(CaiZi.superlight("死而已，没什么需要多说的。")));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		DeathWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return ar;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		DeathWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		DeathWanJiaWanChengShiYongWuPinShiProcedure.execute(context.getPlayer());
		return InteractionResult.SUCCESS;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		DeathWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
		DeathWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			DeathWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		DeathWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		DeathWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return true;
	}
}
