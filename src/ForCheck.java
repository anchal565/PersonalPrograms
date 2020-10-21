public class ForCheck {
    public static void main(String[] args) {
        int a = 2;
        int b=4;
        while(a != 16 && b!= 16){
            System.out.println("a = "+ a +" b = "+b);
            a = a* a;
            b = b*b;
        }

        System.out.println("Now a = "+a +" b= "+b);
    }
}
