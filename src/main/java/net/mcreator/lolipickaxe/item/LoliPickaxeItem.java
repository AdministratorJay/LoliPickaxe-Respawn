
package net.mcreator.lolipickaxe.item;

import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.core.BlockPos;

import net.mcreator.lolipickaxe.procedures.LoliPickaxeRightClickProcedure;
import net.mcreator.lolipickaxe.procedures.LoliPickaxeMakeItemGlowProcedure;
import net.mcreator.lolipickaxe.procedures.LoliPickaxeDangShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.lolipickaxe.procedures.LoliPickaxeDangGongJuChuXianZaiWuPinLanShiProcedure;
import net.mcreator.lolipickaxe.init.LolipickaxeModTabs;
import net.mcreator.lolipickaxe.*;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.gson.JsonObject;
import net.minecraft.network.chat.Component;
import java.util.List;
import net.minecraft.world.item.TooltipFlag;

public class LoliPickaxeItem extends TieredItem {
	public LoliPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return Float.POSITIVE_INFINITY;
			}

			public float getAttackDamageBonus() {
				return Float.POSITIVE_INFINITY;
			}

			public int getLevel() {
				return 2147483647 * 2147483647 * 2147483647;
			}

			public int getEnchantmentValue() {
				return 2147483647 * 2147483647 * 2147483647;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, new Item.Properties().tab(LolipickaxeModTabs.TAB_LOLI_PICKAXE_TAB).fireResistant());
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState blockstate) {
		int tier = 2147483647 * 2147483647 * 2147483647;
		if (tier < 3 && blockstate.is(BlockTags.NEEDS_DIAMOND_TOOL)) {
			return false;
		} else if (tier < 2 && blockstate.is(BlockTags.NEEDS_IRON_TOOL)) {
			return false;
		} else {
			return tier < 1 && blockstate.is(BlockTags.NEEDS_STONE_TOOL)
					? false
					: (blockstate.is(BlockTags.MINEABLE_WITH_AXE) || blockstate.is(BlockTags.MINEABLE_WITH_HOE) || blockstate.is(BlockTags.MINEABLE_WITH_PICKAXE) || blockstate.is(BlockTags.MINEABLE_WITH_SHOVEL));
		}
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
		return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction)
				|| ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
		return Float.POSITIVE_INFINITY;
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		itemstack.hurtAndBreak(1, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		itemstack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		LoliPickaxeDangShiTiBeiGongJuJiZhongShiProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
		return true;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		LoliPickaxeRightClickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
	
	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal(" " + CaiZi.blue("+") + " " + CaiZi.lightrainbow("无限") + CaiZi.blue("%") + " " + CaiZi.blue((Component.translatable("attribute.name.generic.armor").getString()))));
		list.add(Component.literal(" " + CaiZi.blue("+") + " " + CaiZi.lightrainbow("无限") + CaiZi.blue("%") + " " + CaiZi.blue((Component.translatable("attribute.name.generic.armor_toughness").getString()))));
		list.add(Component.literal(" " + CaiZi.blue("+") + " " + CaiZi.lightrainbow("无限") + CaiZi.blue("%") + " " + CaiZi.blue((Component.translatable("attribute.name.generic.attack_damage").getString()))));
		list.add(Component.literal(" " + CaiZi.blue("+") + " " + CaiZi.lightrainbow("无限") + CaiZi.blue("%") + " " + CaiZi.blue((Component.translatable("attribute.name.generic.attack_speed").getString()))));
		list.add(Component.literal(" " + CaiZi.superlight((Component.translatable("item.unbreakable").getString()))));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		LoliPickaxeRightClickProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		LoliPickaxeDangGongJuChuXianZaiWuPinLanShiProcedure.execute(entity, itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return LoliPickaxeMakeItemGlowProcedure.execute();
	}
}
