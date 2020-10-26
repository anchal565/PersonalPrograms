import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/last-index-of-1/0
public class LastIndexOf1 {

    public static int lastIndexOf1(char[] S){
        int N = S.length;
        for(int i=N-1; i>=0; i--){
            if(S[i] == '1'){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T>0){
            sc.nextLine();
            String S = sc.nextLine();
            char[] sArr = S.toCharArray();
            System.out.println(lastIndexOf1(sArr));
            T--;
        }
    }
}
