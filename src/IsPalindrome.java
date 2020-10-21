//https://leetcode.com/explore/featured/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.isEmpty())
            return true;
        StringBuffer sBuffer = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                sBuffer.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        System.out.println(sBuffer.toString());
        int start =0, end = sBuffer.length()-1;
        while(start<end){
            if(sBuffer.charAt(start) != sBuffer.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromWithoutExtraSpace(String s){
        if(s.isEmpty())
            return true;
        int start=0, end=s.length()-1;
        while(start<end){
            if(!(Character.isDigit(s.charAt(start)) || Character.isAlphabetic(s.charAt(start))))
                start++;
            if (!(Character.isDigit(s.charAt(end)) || Character.isAlphabetic(s.charAt(end))))
                end--;
            if((Character.isDigit(s.charAt(start)) || Character.isAlphabetic(s.charAt(start))) &&
                    (Character.isDigit(s.charAt(end)) || Character.isAlphabetic(s.charAt(end)))){
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                    return false;
                else{
                    start++;
                    end--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome("A man, a plan, a canal: Panama");
        boolean isPalindromWithoutExtraSpace = isPalindromWithoutExtraSpace("A man, a plan, a canal: Panama");
        System.out.println(isPalindrome);
        System.out.println(isPalindromWithoutExtraSpace);
    }
}
