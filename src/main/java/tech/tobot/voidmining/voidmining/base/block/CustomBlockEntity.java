package tech.tobot.voidmining.voidmining.base.block;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.MinecraftServer;

public abstract class CustomBlockEntity extends BlockEntity {
  public CustomBlockEntity(final BlockEntityType<?> type) {
    super(type);
    ServerTickEvents.START_SERVER_TICK.register((MinecraftServer server) -> serverTick(server));
  }
  
  public abstract void serverTick(MinecraftServer server);
}
