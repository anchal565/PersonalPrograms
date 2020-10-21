import java.util.Scanner;

//Q: Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
//Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
//Output: Sum found between indexes 2 and 4
public class FindContinuousSubarrayTogivenSum {
    public static void findSubarray(int[] arr, int number){
        int start=0, sum=0, end=0;
        while (end<arr.length){
            while (sum > number){
                sum = sum-arr[start];
                start++;
            }
            if(sum == number){
                System.out.println("Indexes are : "+start +" "+(end-1));
                break;
            }
            sum = sum+arr[end];
            end++;
        }
        if(end == arr.length)
            System.out.println("Subarray doesn't exist");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers in array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter numbers");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        findSubarray(arr,28);
    }
}
