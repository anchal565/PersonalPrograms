public class DeleteWithoutPointer {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static void deleteNode(Node node){
        Node temp = node;
        if(temp.next == null){
            node = null;
            return;
        }
        Node tempNext = temp.next;
        int k = temp.data;
        temp.data = tempNext.data;
        tempNext.data = k;
        if(temp.next.next == null) {
            temp.next = null;
            return;
        }
        temp.next = temp.next.next;
    }

    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        deleteNode(head.next.next.next);
        printList(head);
    }
}
