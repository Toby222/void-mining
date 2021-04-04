package tech.tobot.voidmining.voidmining.base.block;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tech.tobot.voidmining.voidmining.VoidMining;
import tech.tobot.voidmining.voidmining.base.consumer.QuinConsumer;
import tech.tobot.voidmining.voidmining.handler.RegistryHandler;

public interface ICustomBlock {
  default int getMaxStackSize() {return 64;}
  
  @Nullable
  default QuinConsumer<ItemStack, World, Entity, Integer, Boolean> getInventoryTickConsumer() { return null; }
  
  default Identifier register(final Identifier id) {
    RegistryHandler.block(id, (CustomBlock) this);
    createBlockItem(id);
    
    return id;
  }
  
  default void createBlockItem(final Identifier id) {
    VoidMining.LOG.debug("Creating block item for: " + id.toString());
    final Item.Settings settings = new Item.Settings();
    
    settings.group(VoidMining.ITEM_GROUP);
    settings.maxCount(getMaxStackSize());
    
    final CustomBlockItem blockItem = new CustomBlockItem((CustomBlock) this, settings);
    Registry.register(Registry.ITEM, id, blockItem);
  }
}
