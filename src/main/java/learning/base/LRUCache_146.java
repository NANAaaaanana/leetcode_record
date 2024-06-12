package learning.base;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146 LRU缓存机制
 */
public class LRUCache_146 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache_146(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
//
//    private int currentSize;
//    private int capacity;
//    private HashMap<Integer, Integer> map;
//    private Queue<Integer> keyQueue;
//
//    public LRUCache_146(int capacity) {
//        this.currentSize = 0;
//        this.capacity = capacity;
//        this.map = new HashMap();
//        this.keyQueue = new ArrayDeque();
//    }
//
//    public int get(int key) {
//        if(map.get(key) == null ) {
//            return -1;
//        }
//
//        int res = map.get(key);
//        if( currentSize >= capacity ) {
//            map.remove(keyQueue.peek());
//            keyQueue.poll();
//        }
//        keyQueue.add(key);
//        map.put(key, res);
//
//        return res;
//    }
//
//    public void put(int key, int value) {
//        if( currentSize < capacity ) {
//            currentSize += 1;
//        } else {
//            if( map.get(key) != null) {
//                map.remove(key);
//                keyQueue.poll();
//            } else {
//                int previous = keyQueue.peek();
//                map.remove(previous);
//                keyQueue.poll();
//            }
//        }
//
//        keyQueue.add(key);
//        map.put(key, value);
//    }

    public static void main(String[] args) {
        System.out.println("---------initial---------");
        LRUCache_146 lruCache146 = new LRUCache_146(2);

        System.out.println("---------get 2---------");
        System.out.println(lruCache146.get(2));


        System.out.println("---------put 2,6---------");
        lruCache146.put(2, 6);

        System.out.println("---------get 1---------");
        System.out.println(lruCache146.get(1));

        System.out.println("---------put 1,5---------");
        lruCache146.put(1, 5);

        System.out.println("---------put 1,2---------");
        lruCache146.put(1, 2);

        System.out.println("---------get 1---------");
        System.out.println(lruCache146.get(1));

        System.out.println("---------get 2---------");
        System.out.println(lruCache146.get(2));

        System.out.println("---------test finished---------");
    }

}
