//https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0

import java.util.Scanner;

public class StockBuyAndSell {

    public static void calculateProfit(int[] arr, int N){
        int buy = -1, sell = 0;
        for(int i=0; i<N-1 ;i++){
            if(buy < 0){
                if(arr[i] < arr[i+1]){
                    if(sell == 0)
                        System.out.print("("+i);
                    else
                        System.out.print(" ("+i);
                    buy = arr[i];
                    sell = 0;
                }
            }
            else if(buy >= 0){
                if(arr[i+1] < arr[i]){
                    sell = arr[i];
                    System.out.print(" "+i+")" +" ");
                }
            }
            if(buy >= 0 && sell >0){
                buy = -1;
            }

        }
        if(buy >= 0 && arr[N-1] >= arr[N-2]){
            System.out.print(" "+(N-1)+")");
        }
        else if(buy == -1 && sell == 0)
            System.out.println("No profit");
    }
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++){
                A[i] = sc.nextInt();
            }
            calculateProfit(A,N);
            System.out.println();
            T--;
        }
    }
}
