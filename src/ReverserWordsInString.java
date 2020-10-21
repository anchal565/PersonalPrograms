import java.util.Scanner;

public class ReverserWordsInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        sc.nextLine();
        for(int t=0; t<T; t++){
            String S = sc.nextLine();
            System.out.println("String is : "+S);
            String[] strArr = S.split("\\s+");
            String s="";
            for(int i=strArr.length-1; i>=0; i--){
                s=s.concat(strArr[i]);
                if(i!=0)
                    s=s.concat(".");
            }
            System.out.println("Reversed string is : "+s);
        }
    }
}
