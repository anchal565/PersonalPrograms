//https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3380/
//Write a program to find the n-th ugly number.
//
//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
public class UglyNumbers {
    public static int nthUglyNumber(int n) {
        if(n==0)
            return 0;
        int count = 1, num=1;
        while(count != n){
            num++;
            if(num %2 == 0 || num %3 == 0 || num%5 == 0 || num%6 == 0 || num%15 == 0
                    || num%10 == 0 || num%30 == 0){
                count++;
            }
            //num++;
        }

        return num;
    }
    public static void main(String[] args) {
        int result = nthUglyNumber(11);
        System.out.println(result);
    }
}
