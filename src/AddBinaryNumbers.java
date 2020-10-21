//https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/#
public class AddBinaryNumbers {
    public static String addBinary(String a, String b) {
        /*int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int result = num1 + num2;*/

        int length1 = a.length();
        int length2 = b.length();
        int num1=0, num2 = 0, result = 0;
        for(int i=length1-1; i>=0; i--){
            if(a.charAt(i) == ('1')){
                num1 = num1 + (int)Math.pow(2, (length1-1)-i);
            }
        }
        for(int i=length2-1; i>=0; i--){
            if(b.charAt(i) == ('1')){
                num2 = num2 + (int)Math.pow(2, (length2-1)-i);
            }
        }
        result = num1 + num2;
        String resultStr = "";
        while(result > 0){
            resultStr = resultStr+(result%2);
            result = result/2;
        }
        String finalStr = "";
        //StringBuilder sb = new StringBuilder(result);
        for (int i=resultStr.length()-1; i>=0; i--){
            finalStr= finalStr+ resultStr.charAt(i);
        }
        return finalStr;
    }

    public static void main(String[] args) {
        String a = "110";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}
