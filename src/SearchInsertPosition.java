import java.util.HashSet;
import java.util.Random;

//Given a sorted array and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//Eg : Input: [1,3,5,6], 5
//Output: 2
//Eg : Input: [1,3,5,6], 7
//Output: 4
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target < nums[start]){
                return start;
            }
            else if(target > nums[end]){
                return end+1;
            }
            if(nums[mid] < target){
                start = mid+1;
            }
            else
                end = mid-1;
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        int result = searchInsert(arr, 4);
        System.out.println(result);
    }
}
