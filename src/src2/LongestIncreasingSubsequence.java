import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while(T > 0){
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] A = new int[N];
            String arr = bufferedReader.readLine();
            String[] arrStr = arr.trim().split("\\s+");
            for (int i=0; i<N; i++){
                A[i] = Integer.parseInt(arrStr[i]);
            }
            int[] lis = new int[N];
            for (int i=0; i<N; i++)
                lis[i] = 1;
            for(int i=1; i<N; i++){
                for(int j=0; j<i; j++){
                    if(A[j] < A[i])
                        lis[i] = Math.max(lis[j] + 1, lis[i]);
                }
            }
            //System.out.println(Arrays.toString(lis));
            int max = lis[0];
            for (int i=1; i<N; i++){
                if(max < lis[i])
                    max = lis[i];
            }
            System.out.println(max);
            T--;
        }
        bufferedReader.close();

    }
}
