public class FibonacciUsingRecursion {

    public static int fibonacci(int num){
        if(num == 0)
            return 0;
        if(num == 1)
            return 1;
        return fibonacci(num-1) + fibonacci(num-2);
    }

    public static int fibonacciUsingBottomUpDP(int num){
        int[] arr = new int[num];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<num; i++)
            arr[i] = arr[i-1] + arr[i-2];
        return arr[num-1];
    }


    public static void main(String[] args) {
        int num =6;
        int result = fibonacci(num);
        System.out.println("Using recursion" + result);
        result = fibonacciUsingBottomUpDP(num);
        System.out.println("Using bottom up approach : "+result);

    }
}
