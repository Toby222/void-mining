package tech.tobot.voidmining.voidmining.base.consumer;

// ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected
@FunctionalInterface public interface QuinConsumer <T1, T2, T3, T4, T5> {
  void accept(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5);
}