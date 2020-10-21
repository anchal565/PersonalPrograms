public class Add2LL {
    public static void printList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head){
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        Node newHead = null;
        newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static Node addLL(Node head1, Node head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        int carry = 0, value = 0;
        Node head3 = new Node(head1.data);
        Node temp = null;
        while (head1 != null || head2 != null){
            if(head1 == null)
                value = 0 + head2.data + carry;
            if(head2 == null)
                value = head1.data + 0 + carry;
            else
                value = head1.data + head2.data + carry;
            if(temp != null) {
                temp.next = new Node(value % 10);
                temp = temp.next;
            }
            else {
                head3.data = value % 10;
                temp = head3;
            }
            carry = value/10;
            if(head1!= null)
                head1 = head1.next;
            if(head2 != null)
                head2 = head2.next;
        }
        if(carry>0)
            temp.next = new Node(carry);
        return head3;
    }

    public static void main(String[] args) {
        Node head1 = new Node(6);
        head1.next = new Node(3);
        //head1.next.next = new Node(5);
        Node head2 = new Node(7);
        //head2.next = new Node(5);
        //head2.next.next = new Node(9);
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node head3 = addLL(head1, head2);
        Node newHead = reverse(head3);
        //head1.next.next.next = new Node(5);
        //head.next.next.next.next = new Node(6);
        //head.next.next.next.next.next = new Node(6);
        printList(newHead);
    }
}
