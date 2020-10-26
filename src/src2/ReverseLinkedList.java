public class ReverseLinkedList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }

    public static void reverseWithoutUsingRecur(Node node){
        /*if(node == null){
            return;
        }*/
        Node curr = head;
        Node prev = null;
        Node nextt = head.next;
        while (curr != null){
            curr.next = prev;
            prev = curr;
            curr = nextt;
            if(nextt == null)
                nextt = null;
            else
             nextt = nextt.next;
        }
        head = prev;
    }

    public static Node reverseUsingRecur(Node curr, Node nextt, Node prev){
        if(curr == null)
            return head = prev;
        curr.next = prev;
        prev = curr;
        curr = nextt;
        if(nextt == null)
            nextt = null;
        else
            nextt = nextt.next;
        return reverseUsingRecur(curr, nextt, prev);
    }
    public static void printList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        reverseWithoutUsingRecur(head);
        printList(head);

        reverseUsingRecur(head, head.next, null);
        printList(head);
    }
}
