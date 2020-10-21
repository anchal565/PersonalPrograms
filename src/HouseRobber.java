//https://leetcode.com/explore/featured/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3459/
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length > 1)
            nums[1] = Math.max(nums[1], nums[0]);
        for(int i=2; i<nums.length; i++){
            nums[i] = Math.max(nums[i-1], nums[i]+nums[i-2]);
        }
        return nums[nums.length -1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.rob(nums);
    }
}
