package tech.tobot.voidmining.voidmining.content;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.Validate;
import tech.tobot.voidmining.voidmining.VoidMining;
import tech.tobot.voidmining.voidmining.blockentity.VoidMinerEntity;

import java.util.function.Supplier;

public class VMBlockEntities {
  public static BlockEntityType<VoidMinerEntity> VOID_MINER = VMBlockEntities
      .register(VoidMinerEntity::new, "void_miner", VMBlocks.VOID_MINER);
  
  private static <T extends BlockEntity> BlockEntityType<T> register(
      final Supplier<T> supplier, final String name, final Block... blocks
  ) {
    Validate.isTrue(blocks.length > 0, "no blocks for blockEntity entity type!");
    return VMBlockEntities.register(VoidMining.identifier(name), BlockEntityType.Builder.create(supplier, blocks));
  }
  
  private static <T extends BlockEntity> BlockEntityType<T> register(
      final Identifier id, final BlockEntityType.Builder<T> builder
  ) {
    final BlockEntityType<T> blockEntityType = builder.build(null);
    Registry.register(Registry.BLOCK_ENTITY_TYPE, id, blockEntityType);
    return blockEntityType;
  }
}
