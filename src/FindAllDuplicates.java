import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/explore/featured/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3414/
public class FindAllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int temp = 0;
            if(nums[i] < 1)
                i++;
            else if(i == nums[i]-1){
                nums[i] = -1;
                i++;
            }
            else{
                if(nums[nums[i]-1] >= 0){
                    temp = nums[nums[i]-1];
                    nums[nums[i]-1] = -1;
                    nums[i] = temp;
                }
                else{
                    list.add(nums[i]);
                    nums[i] = 0;
                    i++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,3,1};
        System.out.println(Arrays.asList(findDuplicates(arr)));
    }
}
