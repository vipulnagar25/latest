package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheByLinkedHasMap<K, V> {
  private final int capacity;
  private final Map<K, V> cache;

  public LRUCacheByLinkedHasMap(int capacity) {
    this.capacity = capacity;
    this.cache = new LinkedHashMap<>();
  }

  public V get(K key) {
    return cache.getOrDefault(key, null);
  }

  public void put(K key, V value) {

    if (!cache.containsKey(key) && cache.size() >= capacity) {
      K leastRecentlyUsedKey = cache.keySet().iterator().next();
      cache.remove(leastRecentlyUsedKey);
    }
    cache.put(key, value);
  }

  public void print() {
    cache.forEach((k, v) -> System.out.println(k + " -> " + v));
  }

  static void main(String[] args) {
    var cache = new LRUCacheByLinkedHasMap<>(3);
    cache.put(1, "1");
    cache.put(2, "2");
    cache.put(3, "3");

    cache.print();
    System.out.println("+++++++++++");
    cache.put(4, "4");
    cache.print();
    System.out.println("+++++++++++");
    /*cache.put(5, "5");
    cache.print();*/

    /*  System.out.println(cache.get(5));
    cache.put(5, "5");
    cache.print();
    cache.print();*/

  }
}
