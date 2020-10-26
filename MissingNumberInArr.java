import java.util.Scanner;

public class MissingNumberInArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int[] C = new int[N];
            int sumOfArr = 0;
            for(int i=0; i<N-1; i++) {
                C[i] = sc.nextInt();
                sumOfArr = sumOfArr + C[i];
            }
            /*int xorOfAll = 1;
            for(int i=2; i<=N; i++){
                xorOfAll = xorOfAll ^ i;
            }
            int xorOfArr = C[0];
            for(int i= 1; i<N-1; i++)
                xorOfArr = xorOfArr ^ C[i];
            System.out.println(xorOfAll ^ xorOfArr);*/

            int sumOfAll = (N*(N+1))/2;
            System.out.println(sumOfAll - sumOfArr);

        }
    }
}
