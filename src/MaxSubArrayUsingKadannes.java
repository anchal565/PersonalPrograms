import java.util.Scanner;

public class MaxSubArrayUsingKadannes {
    //without using other array
    public static void maxSumArray(int[] arr, int N){
        int temp = arr[0];
        int max = arr[0];
        int start = 0, startTemp = 0, end = 0;
        for(int i=1; i<N; i++){
            if(arr[i] > temp+arr[i]){
                startTemp = i;
                temp = arr[i];
            }
            else {
                temp = temp+arr[i];
            }
            //temp = Math.max(arr[i], temp+arr[i]);
            if(max<temp){
                start = startTemp;
                max = temp;
                end = i;
            }
        }
        System.out.println("Maximum sum is : "+max);
        System.out.println("Start is : "+start +" end is : "+end);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int[] sumArray = new int[N];
        sumArray[0] = arr[0];
        for (int i=1; i<N; i++){
            sumArray[i] = Math.max(arr[i], sumArray[i-1]+arr[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i=N-1; i>=0; i--){
            if(max < sumArray[i]) {
                max = sumArray[i];
            }
        }
        System.out.println("Max is : "+max);

        System.out.println("Without using O(n) space solution : ");
        maxSumArray(arr, N);
    }
}
