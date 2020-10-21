import java.util.Scanner;

//Given an array of elements which is first increasing and then may be decreasing, find the maximum element in the array.
public class MaxElementInArray {

    //In O(n)
    public void findMax(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(max<arr[i])
                max = arr[i];
        }
        System.out.println("max element is : "+max);
    }
    // In O(log n)
    public int findMaxUsingBinary(int[] arr){
        int start =0, end = arr.length-1;
        int mid=0;
        while (start<end){
            mid = (start+end)/2;
            if(mid<end && mid>start && arr[mid]>arr[mid+1] && arr[mid] < arr[mid-1])
                return arr[mid-1];
            if(mid < end && arr[mid] > arr[mid+1]) {
                return arr[mid];
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return arr[mid-1];
            }
            if(arr[mid] >= arr[start]){
                start = mid+1;
            }
            else {
                end=mid-1;
            }
        }
        if(start == end)
            return arr[start];
        else
            return -1;

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
        MaxElementInArray maxElement = new MaxElementInArray();
        //maxElement.findMax(arr);
        int max = maxElement.findMaxUsingBinary(arr);
        System.out.println("Max is : "+max);
    }
}
