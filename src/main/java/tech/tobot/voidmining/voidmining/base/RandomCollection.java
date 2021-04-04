package tech.tobot.voidmining.voidmining.base;

import tech.tobot.voidmining.voidmining.VoidMining;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class RandomCollection <E extends RandomCollectionEntry<S>, S> {
  private final NavigableMap<Double, S> map   = new TreeMap<>();
  private final Random                  random;
  private       double                  total = 0;
  
  public RandomCollection(final E... items) {
    this(new Random(), items);
  }
  
  public RandomCollection(final Random random, final E... items) {
    this.random = random;
    for(final E item : items) {
      add(item.relativeChance, item.val);
    }
  }
  
  public RandomCollection<E, S> add(final double weight, final S result) {
    VoidMining.LOG.debug("Adding item to RandomCollection - " + result.toString() + " - with weight - " + weight);
    if(weight > 0) {
      total += weight;
      map.put(total, result);
    }
    return this;
  }
  
  public S next() {
    final double value = random.nextDouble() * total;
    VoidMining.LOG.debug(
        "Getting value of RandomCollection of size " + map
            .size() + " random value " + value + "  total " + total);
    return map.higherEntry(value).getValue();
  }
}
