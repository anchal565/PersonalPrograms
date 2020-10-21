//June leet code challenge - https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/
//Given a string s and a string t, check if s is subsequence of t.
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
// of the characters without disturbing the relative positions of the remaining characters.
// (ie, "ace" is a subsequence of "abcde" while "aec" is not).
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        return recur(s, t, 0, 0);
    }
    public boolean recur(String s, String t, int index, int i){
        if(index == s.length())
            return true;
        if(i == t.length())
            return false;
        if((s.charAt(index)) == (t.charAt(i))){
            return recur(s,t,index+1, i+1);
        }
        else{
            return recur(s, t, index, i+1);
        }
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s= "abc";
        String t = "ahbgdc";
        boolean result = isSubsequence.isSubsequence(s, t);
        System.out.println(result);
    }
}
