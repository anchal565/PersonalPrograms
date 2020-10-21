import java.util.Scanner;

public class A_PowerB_ModC {

    public static  void main(String[] arg){
        Scanner sc =new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int check = B;
        int result =1 ;
        while(check > 0){
            result = (result * A ) % C;
            check--;
        }


        System.out.println("Result is : "+result);


    }
}
