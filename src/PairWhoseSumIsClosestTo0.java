import java.util.Arrays;
import java.util.Scanner;

//: Find a pair that whose sum is closest to zero.
public class PairWhoseSumIsClosestTo0 {

    public static void findPair(int[] arr, int n){
        Arrays.sort(arr);
        int minSum = findPair(arr, n, 0, n-1);
        System.out.println("minimum sum is : "+minSum);

    }
    static int minimum = Integer.MAX_VALUE;
    public static int findPair(int[] arr, int n, int start, int end){
        if(start>=end)
            return minimum;
        int sum = arr[start] + arr[end];
        if(Math.abs(minimum) > Math.abs(sum))
            minimum = sum;
        if(end-start<=1){
            return minimum;
        }

        if(end-start > 1 && arr[start] < 0 && arr[end] < 0){
            return findPair(arr, n, end-1, end);
        }
        else if(arr[start] < 0 && arr[end] > 0){
            if(Math.abs(arr[start]) > Math.abs(arr[end])){
                //start = start+1;
                return findPair(arr, n, start+1, end);
            }
            else if(Math.abs(arr[start]) < Math.abs(arr[end])){
                //end = end-1;
                return findPair(arr, n, start, end-1);
            }
            else {
                //start = start+1;
                //end = end-1;
                return findPair(arr, n, start+1, end-1);
            }
        }
        else if( end-start > 1 && arr[start] > 0 && arr[end] > 0){
            //end = start+1;
            return findPair(arr, n, start, start+1);
        }
        return minimum;
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
        findPair(arr, n);
        //int minSum = findPair(arr, n, 0, n-1 );


    }
}
