import java.util.Scanner;

public class KnapackUsingCombinationApproach {
    static int max=Integer.MIN_VALUE;
    static int maxValue = 0;
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val[] = new int[]{1,2,3};
        int wt[] = new int[]{4,5,6};
        int[] check = new int[val.length];
        result = new int[val.length];
        int  W = 3;
        recur(W,0,0,wt,check,0, val);
        int sum =0;
        /*for(int j =0; j<result.length; j++){
            sum+=result[j];
            //System.out.print(result[j]+" ");
        }
        System.out.println(sum);*/
        System.out.println(maxValue);
    }

    public static void recur(int W, int i , int index , int[] wt, int[] check, int sum, int[] val){
        if(index == check.length)
            return;
        if(sum>W)
            return;
        if(sum <= W && sum != 0)
        {
            int checkSumValue =0;
            for (int j = 0; j < check.length; j++) {
                checkSumValue += check[j];
            }
            if(maxValue < checkSumValue)
                maxValue= checkSumValue;
            /*if(max<sum && sum!=0) {
                max = sum;
                for (int j = 0; j < check.length; j++) {
                    //System.out.print(check[j] + " ");
                    result[j] = check[j];
                }
            }*/
        }
        if(i==wt.length)
            return;

        recur(W, i+1, index, wt, check, sum, val);
        check[index] = val[i];
        recur(W, i+1,index+1, wt, check, sum+wt[i], val);
    }

}

