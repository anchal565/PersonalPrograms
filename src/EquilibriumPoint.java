import java.util.Scanner;

//Q: Equilibrium index of an array is an index such that the sum of elements at lower indexes
// is equal to the sum of elements at higher indexes. For example
//lnput: A[] = {-7, 1, 5, 2, -4, 3, 0}
//Output: 3
//3 is an equilibrium index, because:
//A[0] + A[1] + A[2] = A[4] + A[5] + A[6]e, in an array A:
public class EquilibriumPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while (T>0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            if(N == 1){
                System.out.println("1");
            }
            else {
                int sum = 0, lsum = 0;
                for (int i = 0; i < N; i++) {
                    sum += A[i];
                }
                int i=0;
                for (i = 0; i < N - 1; i++) {
                    sum = sum - A[i];
                    if (lsum == sum) {
                        System.out.println(i);
                        break;
                    }
                    lsum = lsum + A[i];
                }
                if(i == N-1)
                    System.out.println("-1");
            }
            T--;
        }
    }
}
