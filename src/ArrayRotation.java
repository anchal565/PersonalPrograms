import java.util.Scanner;

public class ArrayRotation {
        public static void main(String[] arg){
            int[] arr={1,2,3,4,5,6,7};
            Scanner sc=new Scanner(System.in);
            int d=sc.nextInt();
            rotation(d,arr);

        }

        public static void rotation(int d, int[] arr){
            for (int i=d;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            for(int i=0;i<d;i++){
                System.out.println(arr[i]+" ");
            }


        }

}
