package tech.tobot.voidmining.voidmining.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tech.tobot.voidmining.voidmining.VoidMining;
import tech.tobot.voidmining.voidmining.base.block.CustomBlock;
import tech.tobot.voidmining.voidmining.base.consumer.QuinConsumer;
import tech.tobot.voidmining.voidmining.blockentity.VoidMinerEntity;
import tech.tobot.voidmining.voidmining.content.VMBlocks;

public class VoidMiner extends CustomBlock implements BlockEntityProvider {
  
  public VoidMiner() {
    super("void_miner", FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    VMBlocks.VOID_MINER = this;
    lootTableId         = VoidMining.identifier("blocks/void_miner");
  }
  
  @Override
  @Nullable
  public QuinConsumer<ItemStack, World, Entity, Integer, Boolean> getInventoryTickConsumer() {
    return null;
  }
  
  @Nullable
  @Override
  public BlockEntity createBlockEntity(final BlockView world) {
    return new VoidMinerEntity();
  }
}
