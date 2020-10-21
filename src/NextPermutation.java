import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = findIndex(nums);
        if(index<0){
            Arrays.sort(nums);
            return;
        }
        int temp = nums[index];
        int nextGreater = findNextGreaterIndex(nums, index);
        nums[index] = nums[nextGreater];
        nums[nextGreater] = temp;
        Arrays. sort(nums, index+1, nums.length);

    }

    public int findIndex(int[] nums){

        int i = nums.length-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }

        return i;
    }

    public int findNextGreaterIndex(int[] nums, int i){
        int greaterIndex = i;
        for(int j=i+1; j<nums.length; j++){
            if(nums[j] > nums[i]){
                greaterIndex = j;
            }
        }
        return greaterIndex;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {4,3,8,5,2};
        nextPermutation.nextPermutation(nums);
    }
}
