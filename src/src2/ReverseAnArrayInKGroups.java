import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseAnArrayInKGroups {
    public static void reverse(int[] A, int N, int K){
        int start = 0;
        int check = K - 1;
        if(K>N)
            check = N-1;
        for(int i=1; i<=(Math.ceil((double) N/(double) K)); i++){
            while (start<check) {
                int temp = A[start];
                A[start] = A[check];
                A[check] = temp;
                start++;
                check--;
            }
            start = K*i;
            check = Math.min(start+K-1, N-1);
        }
        for (int i=0; i<N;i++)
            System.out.print(A[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            //int T= sc.nextInt();
            while (T > 0) {
                String input = br.readLine();
                String[] inputArr = input.trim().split("\\s+");
                int N = Integer.parseInt(inputArr[0]);
                int K = Integer.parseInt(inputArr[1]);
                int[] A = new int[N];
                String line = br.readLine();
                String[] strArr = line.trim().split("\\s+");
                System.out.println(Arrays.toString(strArr));
                for (int i = 0; i < N; i++)
                    A[i] = Integer.parseInt(strArr[i]);
                reverse(A, N, K);
                T--;
            }
            br.close();
    }
}
