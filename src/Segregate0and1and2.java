import java.util.Scanner;

public class Segregate0and1and2 {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        segregate(n,arr);
    }

    public static void segregate(int n,int[] arr){
        int low=0,mid=0,high=n-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else if(arr[mid]==2){
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }

        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
