import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistributionProblem {

    public static int chocolateDis(int[] A, int N, int M){
        Arrays.sort(A);
        int min= Integer.MAX_VALUE;
        for(int i=M-1; i<N; i++){
            min = Math.min(min, A[i]-A[i-(M-1)]);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=0; t<T; t++){
            int N= sc.nextInt();
            int[] A = new int[N];
            for(int i=0;i<N; i++)
                A[i] = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(chocolateDis(A,N,M));
        }
    }
}
