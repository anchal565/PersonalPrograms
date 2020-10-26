public class Segregate01n2InLL {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node segregate(Node head){
        Node temp = head;
        Node head0 = new Node(0);
        Node head1 = new Node(0);
        Node head2 = new Node(0);
        Node zero = head0;
        Node one = head1;
        Node two = head2;
        while (temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        if(head1.next == null){
            zero.next = head2.next;
        }
        else {
            zero.next = head1.next;
        }
        if(head2.next == null){
            one.next = null;
        }
        else
            one.next = head2.next;
        two.next = null;
        return head0.next;
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
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        Node newHead = segregate(head);
        printList(newHead);
    }
}
