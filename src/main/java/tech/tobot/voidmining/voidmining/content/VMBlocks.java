package tech.tobot.voidmining.voidmining.content;

import net.minecraft.block.Block;
import tech.tobot.voidmining.voidmining.block.VoidMiner;

public class VMBlocks {
  public static Block VOID_MINER;
  
  public static void init() {
    VMBlocks.VOID_MINER = new VoidMiner();
  }
}
