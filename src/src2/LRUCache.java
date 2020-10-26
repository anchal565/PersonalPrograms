import java.util.*;

public class LRUCache {
    static Deque<Integer> deque;
    static Map<Integer,Integer> map;
    static int capacity;

    public LRUCache(int N) {
        capacity = N;
        map = new HashMap<>();
        deque = new LinkedList<>();
    }

    public static int get(int x) {

        if(deque.isEmpty())
            return -1;
        int result = 0;
        Iterator iterator = deque.iterator();
        while (iterator.hasNext()){
            if((Integer) iterator.next() == x){
                result = map.get(x);
                deque.removeFirstOccurrence(x);
                deque.addFirst(x);
                return result;
                //return map.get(x);
            }
        }
        return -1;
    }

    public static void set(int x, int y) {
       if(deque.size() == capacity){
           if(deque.contains(x)){
               /*int index = 0, i = 0;
               Iterator iterator = deque.iterator();
               while (iterator.hasNext()){
                   if((Integer)iterator.next() == x)
                   {
                       index = i;
                       break;
                   }
                   i++;
               }*/
               deque.removeFirstOccurrence(x);
               //deque.remove(index);
               deque.addFirst(x);
               map.put(x,y);
           }
           else {
               deque.removeLast();
               deque.push(x);
               map.put(x,y);
           }
       }
       else {
           if(deque.contains(x)){
               deque.removeFirstOccurrence(x);
               //deque.remove(index);
               deque.addFirst(x);
               map.put(x,y);
           }
           else {
               deque.push(x);
               map.put(x, y);
           }
       }
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        System.out.println(get(1));
        set(1,6);
        System.out.println(deque);
        set(2,7);
        System.out.println(deque);
        set(3,7);
        System.out.println(deque);
        set(2,9);
        System.out.println(deque);
        set(5,5);
        System.out.println(deque);

    }
}
