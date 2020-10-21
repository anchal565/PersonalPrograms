public class Merge2LLto1 {
    public static void printList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node merge(Node head1, Node head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        Node newHead=null, temp=null;
        while (head1!=null || head2!=null){
            if(head1 == null){
                temp.next = head2;
                return newHead;
            }
            if(head2 == null){
                temp.next = head1;
                return newHead;
            }
            if(head1.data < head2.data){
                if(newHead == null) {
                    newHead = head1;
                    head1 = head1.next;
                    temp = newHead;
                }
                else{
                    temp.next = head1;
                    temp = temp.next;
                    head1 = head1.next;
                }
            }
            else {
                if(newHead == null) {
                    newHead = head2;
                    head2 = head2.next;
                    temp = newHead;
                }
                else{
                    temp.next = head2;
                    temp = temp.next;
                    head2 = head2.next;
                }

            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(12);
        head2.next.next.next = new Node(13);
        //head.next.next.next.next.next = new Node(6);
        Node head = merge(head1, head2);
        printList(head);
    }
}
