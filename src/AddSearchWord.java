import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/explore/featured/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3413/
public class AddSearchWord {
    Set<String> set;
    public AddSearchWord(){
       set = new HashSet<>();
    }
    public  void addWord(String word) {
        set.add(word);
    }

    public  boolean search(String word) {
        //return set.contains()
        return false;
    }

    public static void main(String[] args) {

    }
}
