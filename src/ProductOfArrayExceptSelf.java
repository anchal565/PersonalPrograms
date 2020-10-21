//Input:  [1,2,3,4]
//Output: [24,12,8,6]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];
        for(int i=0 ;i<N; i++)
            result[i] = 1;

        for(int i=1; i<N; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int prod = 1;

        for(int i=N-1; i>=0; i--){
            result[i] = result[i] * prod;
            prod = prod*nums[i];
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String arr = br.readLine();
        String[] inputArr = arr.trim().split("\\s+");
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(inputArr[i]);
        }
        productExceptSelf(A);
    }
}
