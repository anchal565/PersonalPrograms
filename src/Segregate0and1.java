import java.util.Scanner;

public class Segregate0and1 {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int index=0;
        int temp;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                index++;
            }

        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
