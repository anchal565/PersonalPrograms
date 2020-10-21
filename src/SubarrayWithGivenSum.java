import java.util.Scanner;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int sum = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0 ; i<N; i++){
                arr[i] = sc.nextInt();
            }
            int currSum = arr[0];
            int start = 0;
            int x=0;
            for(x=start+1; x<N; x++){
                //if(currSum < sum)
                currSum = currSum + arr[x];
                while(currSum > sum && start<x) {
                    currSum = currSum - arr[start];
                    start++;
                }
                if(currSum == sum){
                    //System.out.println("subarray is : "+ start + " and "+ (x-1));
                    break;
                }



            }
            if(currSum == sum){
                System.out.println("subarray is : "+ (start+1) + " and "+ (x+1));
                //break;
            }
            if(currSum != sum)
                System.out.println("-1");

        }
    }
}
