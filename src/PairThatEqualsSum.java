import java.util.Arrays;
import java.util.Scanner;

//Q: Given an array, find a pair that equals a given sum.
public class PairThatEqualsSum {

    public void pairThatEqualSum(int sum, int[] arr, int n){
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        boolean flag = false;
        while (end>start){
            if(arr[end] + arr[start] == sum){
                System.out.println(arr[start]+" "+arr[end]);
                if(arr[end-1] == arr[end]){
                    end--;
                }
                else{
                    start++;
                }
                flag = true;
            }
            else if(arr[start]+arr[end] > sum){
                end--;
            }
            else {
                start++;
            }
        }
        if(flag == false)
            System.out.println("No pairs present");

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
        System.out.println("Enter sum");
        int sum = sc.nextInt();
        PairThatEqualsSum classObject = new PairThatEqualsSum();
        classObject.pairThatEqualSum(sum,arr,n);
    }
}
