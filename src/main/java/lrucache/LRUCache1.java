package lrucache;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache1 {

    HashMap cache;
    LinkedList order ;
    int capacity;
    int size;
    public LRUCache1(int capacity) {
        cache = new HashMap(capacity);
        order = new LinkedList();
        this.capacity = capacity;
        this.size = 0;
    }

    private void updateUsage(int key) {
        //update order
        order.removeFirstOccurrence(key);
        order.add(key);
        //System.out.println("Order " + order);
    }

    private void evict(int key) {
        //evict
        //System.out.println("Order " + order);
        int to_evict = (int) order.removeFirst();

        //System.out.println("Evict key " + to_evict);
        //System.out.println(Arrays.asList(cache));
        cache.remove(to_evict);
        //System.out.println(Arrays.asList(cache));
    }

    public int get(int key) {
        if(cache.containsKey(key))
            updateUsage(key);
        return (int) cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        //System.out.println("Size " + cache.size());
        //System.out.println("capacity " + capacity);
        //System.out.println(Arrays.asList(cache));
        // already exists case
        if(cache.containsKey(key)) {
            //update
            cache.put(key,value);


        } else {
            //System.out.println("Adding key " + key );

            cache.put(key, value);

            if(cache.size()>capacity) {
                evict(key);
            }


        }
        updateUsage(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */