import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

public class PythagoreanTriplet {

    public static void pythagoreanTriplet(int[] A, int N){
        Arrays.sort(A);
        int first = 0;
        int second = 1;
        int sum = 2;
        while(sum<N){
            first =0;
            second = sum-1;
            while (first<second) {
                if (Math.pow(A[first], 2) + Math.pow(A[second], 2) == Math.pow(A[sum], 2)) {
                    System.out.println("Yes");
                    return;
                }
                else if (Math.pow(A[first], 2) + Math.pow(A[second], 2) > Math.pow(A[sum], 2)) {
                    second--;
                }
                else {
                    first++;
                }
            }
            sum++;
        }
        System.out.println("No");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T>0){
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++)
                A[i] = sc.nextInt();
            pythagoreanTriplet(A, N);
            T--;
        }
    }
}
