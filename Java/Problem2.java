package Java;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        // We initialize a new LinkedHashMap, setting accessOrder to true, this tells LinkedHashMap to maintain elements in the order of access, not insertion
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true){
            //  Override of removeEldestEntry method
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > capacity; // Remove the least used entry when map size is bigger than capacity
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1); // If key not found, return -1
    }
    
    public void put(int key, int value) {
        // If the key already exists, its value will be updated; if not, a new key-value pair will be inserted
        cache.put(key, value);
    }
}