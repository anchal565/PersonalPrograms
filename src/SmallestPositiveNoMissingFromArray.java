import java.util.Arrays;
import java.util.Scanner;

//Q: You are given an unsorted array with both positive and negative elements.
// You have to find the smallest positive number missing from the array in O(n) time using constant extra space.
// You can modify the original array.
//
//Input:  {2, 3, 7, 6, 8, -1, -10, 15}
// Output: 1
// Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
// Output: 4
// Input: {1, 1, 0, -1, -2}
// Output: 2
public class SmallestPositiveNoMissingFromArray {
    public static void findSmallestPositive(int[] arr, int N){
        int startIndex = segregatePositive(arr, N);
        System.out.println(Arrays.toString(arr));
        System.out.println("count of negavtive num is : "+startIndex);
        //int startIndex = countOfNeg;
        for(int i=startIndex; i<N;i++){
            int temp = Math.abs(arr[i]);
            if(temp <= N-startIndex && temp>0){
                 if(arr[startIndex+temp -1] > 0)
                    arr[startIndex+temp -1] = - arr[startIndex+temp -1];
            }
        }
        System.out.println("After traversal array is : ");
        System.out.println(Arrays.toString(arr));
        int i;
        for(i=startIndex; i<N; i++){
            if(arr[i] >= 0) {
                System.out.println((i - startIndex + 1));
                return;
            }
        }
        if(i==N)
            System.out.println(N-startIndex+1);
    }

    public static int segregatePositive(int[] arr, int N){
        int j=0, temp=0;
        for(int i=0; i<N; i++){
            if(arr[i] <= 0){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        findSmallestPositive(arr, N);
    }
}
