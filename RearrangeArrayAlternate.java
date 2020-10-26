import java.util.Arrays;
import java.util.Scanner;

//Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively
// i.e first element should be max value, second should be min value, third should be second max,
// fourth should be second min and so on...
public class RearrangeArrayAlternate {

    public static void rearrange(int[] arr, int N){
        int start = 0;
        int end = N-1;
        int index = 0;
        int temp =0;
        int temp2 = arr[0];
        /*int temp1 = 0;
        int temp2 = 0;*/
        for(index=0; index<N ;index++){
            if(index%2 == 0){
                temp = temp2;
                //temp = arr[start];
                /*temp1 = arr[index];
                temp2 = arr[index];*/
                arr[index] = arr[end];
                end--;
            }
            else {
                temp2 = arr[index];
                arr[index] = temp;
                start++;

                /*temp2 = arr[index];
                arr[index] = temp1;
                temp1 = temp2;*/
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = sc.nextInt();
            }
            rearrange(arr, N);

        }
    }
}
