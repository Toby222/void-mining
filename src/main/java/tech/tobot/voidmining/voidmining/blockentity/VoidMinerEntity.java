package tech.tobot.voidmining.voidmining.blockentity;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import tech.tobot.voidmining.voidmining.base.BlockEntry;
import tech.tobot.voidmining.voidmining.base.RandomCollection;
import tech.tobot.voidmining.voidmining.base.block.CustomBlockEntity;
import tech.tobot.voidmining.voidmining.content.VMBlockEntities;

public class VoidMinerEntity extends CustomBlockEntity implements Tickable {
  public final static RandomCollection<BlockEntry, Identifier> ORES = new RandomCollection<>(
      new BlockEntry(10d, Blocks.IRON_ORE), new BlockEntry(50d, Blocks.COAL_ORE),
      new BlockEntry(1d, Blocks.DIAMOND_ORE), new BlockEntry(0.01d, Blocks.EMERALD_ORE),
      new BlockEntry(5d, Blocks.REDSTONE_ORE), new BlockEntry(5d, Blocks.GOLD_ORE),
      new BlockEntry(7d, Blocks.LAPIS_ORE), new BlockEntry(0.5d, Blocks.NETHER_QUARTZ_ORE)
  );
  
  public VoidMinerEntity() {
    super(VMBlockEntities.VOID_MINER);
  }
  
  @Override
  public void tick() {
    if(world.isClient) {
      return;
    }
    final BlockPos above = pos.up();
    world.getBiome(pos).getGenerationSettings();
    if(world.getBlockState(above).isAir()) {
      Block randomBlock;
      do {
        randomBlock = Registry.BLOCK.get(VoidMinerEntity.ORES.next());
      } while(randomBlock == null);
  
      world.setBlockState(above, randomBlock.getDefaultState());
    }
  }
}
