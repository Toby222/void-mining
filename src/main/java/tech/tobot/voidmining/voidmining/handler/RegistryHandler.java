package tech.tobot.voidmining.voidmining.handler;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistryHandler {
  
  public static Block block(final Identifier id, final Block block) {
    return Registry.register(Registry.BLOCK, id, block);
  }
}
