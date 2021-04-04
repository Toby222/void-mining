package tech.tobot.voidmining.voidmining.base;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntry extends RandomCollectionEntry<Identifier> {
  public BlockEntry(final double relativeChance, final Identifier id) {
    super(relativeChance, id);
  }
  
  public BlockEntry(final double relativeChance, final Block block) {
    super(relativeChance, Registry.BLOCK.getId(block));
  }
}
