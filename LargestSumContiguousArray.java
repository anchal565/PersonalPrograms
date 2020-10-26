import java.util.Scanner;

public class LargestSumContiguousArray {

    public static void largestSumArray(int N, int[] A){
        int max =0, currSum=0;
        for(int i=0; i<N; i++){
            currSum = currSum + A[i];
            if(currSum < 0){
                currSum = 0;
            }
            if(currSum > max){
                max = currSum;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++)
                A[i] = sc.nextInt();
            largestSumArray(N, A);

        }
    }
}
