//Q: Find maximum sum subarray. not considering subarray with negatives
public class MaxSumSubarray {
    public void maxSum(int[] arr, int n){
        int sum = 0, max=Integer.MIN_VALUE;
        int start =0, end =0;
        boolean flag = false;
        for (int i=0; i<n; i++){
            if(arr[i]>0){
                sum = sum+ arr[i];
            }
            else if(arr[i]<0) {
                sum = 0;
                flag = false;
            }
            if(max<=sum) {
                if(flag == false)
                    start = i;
                else
                    end = i;
                max = sum;
                flag = true;
            }
        }
        System.out.println("max is : "+max);
        System.out.println("Subarray is : "+start +" "+end);
    }
    public static void main(String[] args) {
        //int[] arr ={1,4,-7,8,2,-1,-2};
        //int[] arr = {-2,5,4,-6,9,1,-5};
        int[] arr = {-9,-0,-3,-4};
        MaxSumSubarray maxObj = new MaxSumSubarray();
        maxObj.maxSum(arr, arr.length);
    }
}
