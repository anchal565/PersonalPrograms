import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class RotateLinkList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node rotate(Node head, int k){
        int count = 0;
        Node temp = head;
        Node endNode = null;
        Node startNode = null;
        int length = length(head);
        if(k >= length)
            k = k % length ;
        if(k == 0)
            return head;
        Node lastNode_initial = null;
        while(temp != null){
            count = count + 1;
            if(count == k) {
                endNode = temp;
                    startNode = endNode.next;
            }
            if(temp.next == null)
                lastNode_initial = temp;
            temp = temp.next;
        }
        lastNode_initial.next = head;
        endNode.next = null;
        head = startNode;
        return head;

    }

    public static int length(Node head){
        Node temp = head;
        int length = 0;
        while(temp != null)
        {
            length ++;
            temp = temp.next;
        }
        return length;
    }

    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(9);
        Node node = rotate(head, k);
        printList(node);
    }
}
