public class FactorialUsingRecursion {

    public static int factorial(int num){
        if(num==1 || num==0)
            return 1;
        else {
            return num * factorial(num-1);
        }
    }
    public static void main(String[] args) {
        int num = 3;
        int fact = factorial(num);
        System.out.println(fact);
    }
}
