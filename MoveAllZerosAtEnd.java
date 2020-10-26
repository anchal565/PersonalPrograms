import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MoveAllZerosAtEnd {
    public static void main(String[] args) {
        int arr[] = {1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0};
        int index = 0;
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        String text ="";
        char[] v = text.toCharArray();
        for(int i=0; i<v.length;i++){
            if(stack.peek() == map.get(v[i])){

            }
                else
                    stack.push(v[i]);
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
