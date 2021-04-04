package tech.tobot.voidmining.voidmining;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import tech.tobot.voidmining.voidmining.content.VMBlocks;
import tech.tobot.voidmining.voidmining.handler.LogHandler;

public class VoidMining implements ModInitializer {
  public static final  Boolean    DEBUG      = true;
  private static final String     MOD_ID     = "voidmining";
  public static final  ItemGroup  ITEM_GROUP = new ItemGroup(0, VoidMining.identifier("creative_tab").toString()) {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Items.BARRIER);
    }
  };
  public static final  LogHandler LOG        = new LogHandler(VoidMining.MOD_ID);
  private static       boolean    hasRun     = false;
  
  public static Identifier identifier(final String id) {
    return new Identifier(VoidMining.MOD_ID, id);
  }
  
  @Override
  public void onInitialize() {
    if(!VoidMining.hasRun) VoidMining.hasRun = true;
    VMBlocks.init();
  }
}
