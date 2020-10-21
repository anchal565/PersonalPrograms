import java.util.Scanner;


public class MaxProfitByBuyingSellingShares {
    static int max2=0;
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int[] priceArr={90, 80, 70, 60, 50};
        int K=sc.nextInt();
        int[] data=new int[2*K];
        recur(K,priceArr,0,0,0,data,0);
        System.out.println("Max profit is : "+max2);
    }

    public static void recur(int K, int[] priceArr,int i, int index, int sum,int[] data,int max){
        if(index==(2*K)) {
            for(int x=1;x<data.length;x+=2){
                sum=sum+(data[x]-data[x-1]);

            }
            if(max2<sum)
                max2=sum;
            return;
            //return max2;
        }
        if(i==priceArr.length)
            return;
            //return max2;

        recur(K,priceArr,i+1,index,sum,data,max);
        if(((index+1)/2!=0) || (index==0) || ((index+1)/2==0 && data[index-1]<priceArr[i])) {
            data[index] = priceArr[i];
            recur(K,priceArr,i+1,index+1,sum,data,max);
            data[index]=0;
        }
        //return max2;
    }
}
