package tech.tobot.voidmining.voidmining.base;

public abstract class RandomCollectionEntry <T> {
  double relativeChance;
  T      val;
  
  public RandomCollectionEntry(final double relativeChance, final T val) {
    this.relativeChance = relativeChance;
    this.val            = val;
  }
}
