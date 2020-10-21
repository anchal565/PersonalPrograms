import java.util.Scanner;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        char sign='+';
        if((dividend<0 && divisor>0) || (divisor<0 && dividend>0)){
            sign = '-';
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;
        long longDividend = dividend;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int count = 0;
        while(dividend >= divisor){
            dividend = dividend-divisor;
            count ++;
        }
        if(sign == '-')
            count = -count;
        return count;

    }

    public static int divide2(int dividend1, int divisor1) {
        char sign = '+';
        long dividend = dividend1;
        long divisor = divisor1;
        if((dividend>0) ^ (divisor>0))
            sign='-';
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        long check = divisor, maxValue = 1;
        while ((check<<1) <= dividend){
            check = check<<1;
            maxValue = maxValue<<1;
        }
        long result = 0;
        while (dividend >= divisor){
            if(check  <= dividend){
                result = result + maxValue;
                dividend = dividend - check;
            }
            check = check>>1;
            maxValue = maxValue>>1;
        }
        if(sign == '-')
            return -(int)result;
        return (int)result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();
        int count = divide2(dividend,divisor);
        System.out.println("Value is : "+count);
    }
}
