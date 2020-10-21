import java.util.Scanner;

public class CombinationInArray {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        int[] data=new int[k];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        recursion(0,0,arr,k,n,data);


    }

    public static void recursion(int i, int index,int[] arr, int k,int n,int[] data){
        if(index==k){
            for(int j=0;j<k;j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println();
            return;
        }

        if(i==n)
            return;
        else{
            recursion(i+1,index,arr,k,n,data);
            data[index]=arr[i];
            recursion(i+1,index+1,arr,k,n,data);
        }
    }
}
