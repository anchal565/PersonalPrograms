import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int t=0; t<T; t++){
            String S = sc.nextLine();
            HashMap<Character,Character> hashmap = new HashMap<>();
            hashmap.put(')','(');
            hashmap.put('}','{');
            hashmap.put(']','[');
            Stack<Character> stack = new Stack<>();
            for(int s=0;s<S.length();s++){
                //stack.push(S.charAt(s));
                if(stack.isEmpty())
                    stack.push(S.charAt(s));
                else{
                    if(stack.peek() == hashmap.get(S.charAt(s)))
                        stack.pop();
                    else
                        stack.push(S.charAt(s));

                }
            }
            if(stack.isEmpty())
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }


    }
}
