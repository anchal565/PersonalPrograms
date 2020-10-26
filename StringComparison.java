public class StringComparison {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = "abc";
        System.out.println(a == b.intern());
        System.out.println(a.intern() == c.intern());
        System.out.println(a. equals(b));
        System.out.println(a. equals(c));
        System.out.println(a == b);
        System.out.println(a == c);
    }
}
