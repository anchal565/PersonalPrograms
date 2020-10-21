//https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/
//Given a non-empty array of integers, every element appears three times except for one,
// which appears exactly once. Find that single one.
//Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class FindSingleNumber {
    public static int singleNumber(int[] nums) {
        int result =0;
        for(int i=0; i<=31; i++){
            int digit = 1<<i;
            //System.out.println("Digit : "+digit);
            int value = 0, sum =0;
            for(int j=0; j<nums.length; j++){
                value = nums[j] & digit;
                if(value != 0)
                    sum++;
            }
            if(sum%3 != 0){
                result= result|digit;
                //System.out.println("Result is : "+result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,-2,5,5};
        int result = singleNumber(arr);
        System.out.println(result);
    }
}
