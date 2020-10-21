import java.util.Scanner;

public class FinalDestinationUsingMaths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T; t++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            long x = sc.nextInt();

            long i=Math.abs(a);
            long j = Math.abs(b);

                if (x < (i + j))
                    System.out.println("0");
                else {
                    if ((x - (i + j)) % 2 == 0)
                        System.out.println("1");
                    else
                        System.out.println("0");
                }
        }
    }
}
