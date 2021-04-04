package tech.tobot.voidmining.voidmining.base.block;

import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tech.tobot.voidmining.voidmining.base.consumer.QuinConsumer;

public class CustomBlockItem <B extends CustomBlock> extends BlockItem {
  private final QuinConsumer<ItemStack, World, Entity, Integer, Boolean> inventoryTickConsumer;
  
  CustomBlockItem(final B block, final Settings settings) {
    super(block, settings);
    
    // callable inventory tick consumer from the block
    this.inventoryTickConsumer = block.getInventoryTickConsumer();
  }
  
  @Override
  public void inventoryTick(
      final ItemStack stack, final World worldIn, final Entity entityIn, final int itemSlot, final boolean isSelected
  ) {
    if(this.inventoryTickConsumer != null) {
      this.inventoryTickConsumer
          .accept(stack, worldIn, entityIn, itemSlot, isSelected);
    }
  }
}
