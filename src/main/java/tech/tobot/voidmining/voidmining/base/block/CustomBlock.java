package tech.tobot.voidmining.voidmining.base.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import tech.tobot.voidmining.voidmining.VoidMining;

public abstract class CustomBlock extends Block implements ICustomBlock {
  private final Identifier blockIdentifier;
  
  protected CustomBlock(final String name, final AbstractBlock.Settings settings) {
    super(settings);
    blockIdentifier = VoidMining.identifier(name);
    lootTableId     = VoidMining.identifier("blocks/" + name);
    register(blockIdentifier);
  }
}
