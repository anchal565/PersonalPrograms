import java.util.Arrays;
import java.util.Scanner;

public class Sort0n1n2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++)
                A[i] = sc.nextInt();
            int start = 0, mid = 0, end = N-1;
            while (mid<=end){
                if(A[mid] == 0){
                    int temp = A[mid];
                    A[mid] = A[start];
                    A[start] = temp;
                    start++;
                    mid++;
                }
                else if(A[mid] == 1){
                    mid++;
                }
                else {
                    int temp = A[end];
                    A[end] = A[mid];
                    A[mid] = temp;
                    end--;
                }
            }
            System.out.println(Arrays.toString(A));
        }
    }
}
