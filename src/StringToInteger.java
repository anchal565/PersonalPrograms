import java.util.Scanner;

public class StringToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Value is : "+str);
        if(str.isEmpty()){
            System.out.println("0");
            return;
        }
        str = str.trim();
        char sign;
        if(str.length()>0 && str.charAt(0) == '+') {
            sign = '+';
            str = removeLeadingZeros(str.substring(1));
        }
        else if(str.length()>0 && str.charAt(0) =='-') {
            sign = '-';
            str = removeLeadingZeros(str.substring(1));
        }
        else {
            sign = ' ';
            str = removeLeadingZeros(str.substring(0));
        }
        str = sign + str;
        System.out.println("String after removing leading zeros is : "+str);
        str = str.trim();
        long result;
        if(str.length()>=1){
            if(str.length()>=12)
                result = validNumberFromString(str.substring(0,12));
            else
                result = validNumberFromString(str);
        }
        else
            result = 0;
        if(result < Integer.MIN_VALUE)
            System.out.println("Result is : "+ Integer.MIN_VALUE);
        else if(result > Integer.MAX_VALUE)
            System.out.println("Result is : "+Integer.MAX_VALUE);
        else
            System.out.println("Result is : "+result);
    }

    public static long validNumberFromString(String str){
        String num = "";
        if(str.matches("^[0-9].*")){
            for (int i=0; i<str.length() && Character.isDigit(str.charAt(i)); i++){
                    num = num.concat(String.valueOf(str.charAt(i)));
            }
        }
        else if(str.matches("^[+-].*") && str.length()>=2 && Character.isDigit(str.charAt(1))){
            num = String.valueOf(str.charAt(0));
            for (int i = 1; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
                num = num.concat(String.valueOf(str.charAt(i)));
            }
        }
        else
            num = "0";
        return Long.parseLong(num);

    }
    public static String removeLeadingZeros(String str){
        int i=0;
        while(i<str.length()){
            if(str.charAt(i) == ' ' || str.charAt(i) =='+' || str.charAt(i) =='-')
                return "0";
            else if(str.charAt(i) == '0') {
                str = str.substring(0, i) + ' ' + str.substring(i + 1);
                i++;
            }
            else
                break;
        }
        str = str.trim();
        return str;
    }
}
