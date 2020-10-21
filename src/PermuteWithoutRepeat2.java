import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermuteWithoutRepeat2 {
    static List<List<Integer>> resultList = new ArrayList<>();
    public static void permute(int[] nums, int index){
        if(index == nums.length){
            List<Integer> subList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            resultList.add(subList);
            return;
        }
        for(int i=index; i<nums.length; i++){
            swap(index, i, nums);
            permute(nums, index+1);
            swap(index, i, nums);
        }
    }

    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permute(arr, 0);
        for(List a : resultList){
            System.out.println(Arrays.asList(a));
        }
    }
}
