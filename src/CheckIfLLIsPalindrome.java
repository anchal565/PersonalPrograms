import java.util.Stack;

public class CheckIfLLIsPalindrome {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }
    public static void printList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println();
    }

    private static void palindrome(){
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        Node tempAgain = head;
        while (!stack.isEmpty() && tempAgain != null){
            if(tempAgain.data != stack.pop()){
                System.out.println("Not a palindrome");
                return;
            }
            else {
                tempAgain = tempAgain.next;
            }
        }
        if(stack.isEmpty() && tempAgain == null)
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");
    }
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        palindrome();
        printList(head);

    }
}
