package tech.tobot.voidmining.voidmining.blockentity;

import net.minecraft.server.MinecraftServer;
import tech.tobot.voidmining.voidmining.VoidMining;
import tech.tobot.voidmining.voidmining.base.block.CustomBlockEntity;
import tech.tobot.voidmining.voidmining.content.VMBlockEntities;

public class VoidMinerEntity extends CustomBlockEntity {
  public VoidMinerEntity() {
    super(VMBlockEntities.VOID_MINER);
  }
  
  @Override
  public void serverTick(final MinecraftServer server) {
    VoidMining.LOG.debug("Server tick - " + pos.toString());
  }
}
