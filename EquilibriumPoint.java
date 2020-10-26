import java.util.Scanner;

public class EquilibriumPoint {

    public static void equilibriumPoint(int[] A, int N){
        int sum = 0;
        for(int i=0; i<N; i++)
            sum += A[i];
        int tempSum = 0;
        if(N==0) {
            System.out.println("-1");
            return;
        }

        if(N == 1){
            System.out.println("1");
            return;
        }
        for(int i=0; i<N; i++){
                    if(tempSum*2 + A[i] == sum){
                        System.out.println(i+1);
                        return;
                    }
                    tempSum += A[i];

        }
        System.out.println("-1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++)
                A[i] = sc.nextInt();
            equilibriumPoint(A, N);

        }
    }
}
