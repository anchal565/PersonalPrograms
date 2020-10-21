import java.util.HashMap;
import java.util.Map;
import java.util.Random;
//https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/
//Design a data structure that supports all following operations in average O(1) time.
//
//insert(val): Inserts an item val to the set if not already present.
//remove(val): Removes an item val from the set if present.
//getRandom: Returns a random element from current set of elements.
// Each element must have the same probability of being returned.
public class InsertDeleteGetRandom {
    Map<Integer, Integer> valuetoIndexMap;
    Map<Integer, Integer> indexToValueMap;
    Random random;
    int length;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        valuetoIndexMap = new HashMap<Integer, Integer>();
        indexToValueMap = new HashMap<Integer, Integer>();
        random = new Random();
        length = 0;

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valuetoIndexMap.get(val) == null){
            valuetoIndexMap.put(val, length);
            indexToValueMap.put(length, val);
            length++;
            return true;
        }
        else{
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(valuetoIndexMap.get(val) != null){
            int indexValue = valuetoIndexMap.get(val);
            valuetoIndexMap.remove(val);
            indexToValueMap.remove(indexValue);
            if(length > 1 && indexValue != length-1) {
                int lastIndexValue = indexToValueMap.get(length - 1);
                indexToValueMap.remove(length - 1);
                indexToValueMap.put(indexValue, lastIndexValue);
                valuetoIndexMap.remove(lastIndexValue);
                valuetoIndexMap.put(lastIndexValue, indexValue);
            }
            length = length - 1;
            return true;
        }
        else
            return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomNum = random.nextInt(length);

        //Iterator iterator = set.iterator();

        return indexToValueMap.get(randomNum);
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(3));
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(3));
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.insert(0));
        System.out.println(obj.remove(0));
    }
}
