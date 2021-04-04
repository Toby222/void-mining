package tech.tobot.voidmining.voidmining.base.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

public abstract class CustomBlockEntity extends BlockEntity {
  public CustomBlockEntity(final BlockEntityType<?> type) {
    super(type);
  }
}
