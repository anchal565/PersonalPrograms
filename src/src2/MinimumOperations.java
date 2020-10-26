import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
//You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:
//
//Double the number
//Add one to the number
public class MinimumOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = (Integer.parseInt(br.readLine()));
        while (T>0) {
            int N = (Integer.parseInt(br.readLine()));
            int count = 0;
            while (N>0){
                if((N&1) > 0){
                    count++;
                    N--;
                }
                else {
                    N = N/2;
                    count++;
                }
            }
            System.out.println(count);
            T--;
        }
        br.close();
    }
}
