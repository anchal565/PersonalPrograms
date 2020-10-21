import java.util.*;

public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        long numerator1 = numerator;
        long denominator1 = denominator;
        char sign = ((numerator1>=0)^(denominator1>=0)) ? '-' : '+';
        numerator1 = Math.abs(numerator1);
        denominator1 = Math.abs(denominator1);
        long quotient = numerator1/denominator1;
        StringBuilder result = new StringBuilder();
        result.append(quotient);
        //quotient=Math.abs(quotient);
        LinkedHashMap<Long,Long> map = new LinkedHashMap<>();
        long rem=numerator1%denominator1;
        if(quotient ==0 && rem == 0)
            return "0";
        if(sign =='-')
            result.insert(0,sign);
        if(rem != 0)
            result.append(".");
        long recurringRem = 0L;
        while(!(map.containsKey(rem)) && rem != 0){
                quotient = (rem*10)/denominator1;
                map.put(rem,quotient);
                rem = (10*rem)%quotient;
        }
        if(map.containsKey(rem))
            recurringRem = rem;
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            if(key.equals(recurringRem)){
                result.append("(");
            }
            result.append(map.get(key).toString());
        }
        if(recurringRem != 0)
            result.append(")");
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numerator = sc.nextInt();
        int denominator = sc.nextInt();
        String result = fractionToDecimal(numerator, denominator);
        System.out.println("Result is : "+result);
    }
}