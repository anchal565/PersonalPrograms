import java.util.Arrays;

//find-first-and-last-position-of-element-in-sorted-array/submissions
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
public class FindStartNEndPosInArr {
    public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int[] result = new int[2];
        result[0] = binarySearch(start, end, nums, target, false);
        result[1] = binarySearch(start, end, nums, target, true);
        return result;
    }
    public static int binarySearch(int start, int end, int[] nums, int target, boolean index){
        int mid = (start+end)/2;
        if(nums.length == 0)
            return -1;
        if(start >= end && nums[mid] != target)
            return -1;
        if(nums[mid] == target){
            if(index == false){
                if(mid == 0 || nums[mid-1] != target)
                    return mid;
                else{
                    return binarySearch(start, mid-1, nums, target, index);
                }
            }
            else{
                if(mid == nums.length-1 || nums[mid+1] != target)
                    return mid;
                else{
                    return binarySearch(mid+1, end, nums, target, index);
                }
            }
        }
        else if(nums[mid] < target){
            return binarySearch(mid+1, end, nums, target, index);
        }
        else{
            return binarySearch(start, mid-1, nums, target, index);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,5,8,8,10};
        int[] result= searchRange(arr, 8);
        System.out.println(Arrays.toString(result));
    }
}
