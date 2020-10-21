public class ReverseLinkList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node reverseList(Node head){
        if(head == null)
            return head;
        Node current = head;
        Node nextt = head.next;
        Node prev = null;
        while(current != null){
            current.next = prev;
            prev = current;
            current = nextt;
            if(nextt == null || nextt.next == null)
                nextt = null;
            else
                nextt = nextt.next;
        }
        head = prev;
        return head;
    }

    public static void printList(Node head){
        Node tempNode = head;
        while(tempNode != null)
        {
            System.out.print(tempNode.data +" ");
            tempNode= tempNode.next;
        }
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printList(head);
        System.out.println();
        Node node = reverseList(head);
        printList(node);
    }
}
