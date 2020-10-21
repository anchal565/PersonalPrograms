import java.util.LinkedHashMap;
import java.util.Set;

public class LRUCache {

        int size;
        LinkedHashMap<Integer, Integer> map;
        public LRUCache(int capacity) {
            size = capacity;
            map = new LinkedHashMap<>();

        }

        public int get(int key) {
            if(size > 0){
                if(map.containsKey(key)){
                    int value = map.get(key);
                    map.remove(key);
                    map.put(key,value);
                    return value;
                }
            }
            return -1;
        }

        public void put(int key, int value) {

            if(map.containsKey(key)){
                map.remove(key);
            }
            if(map.size() == size){
                Set keySet = map.keySet();
                map.remove(keySet.iterator().next());
            }
            map.put(key,value);
        }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}
