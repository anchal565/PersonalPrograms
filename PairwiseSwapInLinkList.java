public class PairwiseSwapInLinkList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node pairwiseSwap(Node node){
        Node temp = node;
        while (temp != null && temp.next != null){
            int a = temp.data;
            temp.data = temp.next.data;
            temp.next.data = a;
            temp = temp.next.next;
        }

        return node;
    }

    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        head = new Node(2);
        /*head.next = new Node(4);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(9);*/
        Node node = pairwiseSwap(head);
        printList(node);
    }
}
