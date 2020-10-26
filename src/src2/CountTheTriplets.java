import java.util.Arrays;
import java.util.Scanner;

public class CountTheTriplets {

    public static void countTriplets(int[] A, int N, int count){
        int first = 0;
        int second = 1;
        int sum = 2;
        System.out.println(Arrays.toString(A));
        while(sum<N){
            first = 0;
            second = sum-1;
            while(second > first){
                if(A[first] + A[second] == A[sum]){
                    System.out.println("To checkk: "+A[first]+" "+A[second]);
                    count++;
                    second--;
                }
                else if(A[first] + A[second] < A[sum]){
                    first++;
                }
                else {
                    second--;
                }
            }
            sum++;
        }
        if(count == 0)
            System.out.println("-1");
        else
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++){
                A[i] = sc.nextInt();
            }
            Arrays.sort(A);
            countTriplets(A, N, 0);

        }
    }
}
