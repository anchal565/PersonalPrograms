class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
    }
}
public class ReverseLinkedList {

    public static  Node recur(Node head){
        if(head == null)
            return null;
        Node temp;
        Node curr = head;
        Node prev = null;
        Node nextt = curr.next;
        while (curr != null){
            curr.next = prev;
            prev = curr;
            curr = nextt;
            if(nextt != null)
                nextt = nextt.next;
            else
                nextt = null;
        }
        temp = prev;
        return temp;

    }


    public static Node reverseUsingRecur(Node head){
        if(head == null)
            return null;
        Node newHead = head;
        if(head.next == null)
            return newHead;
        newHead = reverseUsingRecur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    /*public static Node reverseUsingRecur(Node curr, Node nextt, Node prev){
        if(curr == null) {
            return prev;
        }
        curr.next = prev;
        prev = curr;
        curr = nextt;
        if(nextt == null)
            nextt = null;
        else
            nextt = nextt.next;
        return reverseUsingRecur(curr, nextt, prev);
    }*/
    public static void printList(Node head){
        if(head == null) {
            return;
        }
        Node node = head;
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node result = recur(head);
        printList(result);
        //Node temp = reverseUsingRecur(result, result.next, null);
       // printList(temp);
        result = reverseUsingRecur(result);
        printList(result);
    }
}
