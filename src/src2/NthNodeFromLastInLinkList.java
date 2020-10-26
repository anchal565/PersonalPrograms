import java.util.Scanner;

public class NthNodeFromLastInLinkList {

    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static int getNthFromLast(Node head, int n)
    {
        // Your code here
        int count = 0;
        Node temp = head;
        int length = length(head);
        int k = length - n;
        if(n > length)
            return -1;
        if( head == null)
            return -1;
        while (count != k){
            count++;
            temp = temp.next;
        }
        return temp.data;
    }

    public static int length(Node head){
        int length = 0;
        Node temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(7);
        int value = getNthFromLast(head, K);
        System.out.println("Value is : "+value);
    }
}
