import java.util.Stack;

public class CheckIfListIsPlaindrome {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static boolean isPalindrome(Node head){
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        Node tempIterator = head;
        for(int i=0; i<stack.size(); i++){
            if(stack.pop() != tempIterator.data)
                return false;
            else
                tempIterator = tempIterator.next;
        }
        return true;
    }

    public static void main(String[] args) {

        head = new Node(3);
        head.next = new Node(3);
        head.next.next = new Node(3);
        boolean result = isPalindrome(head);
        System.out.println(result);
    }
}
