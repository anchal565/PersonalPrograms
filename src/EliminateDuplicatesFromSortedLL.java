public class EliminateDuplicatesFromSortedLL {
    public static void printList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println();
    }

    private static Node eliminateDuplicate(Node head){
        if(head == null)
            return null;
        Node slow_ptr = head;
        Node fast_ptr = head;
        while (slow_ptr != null){
            fast_ptr = slow_ptr.next;
            while (fast_ptr != null && slow_ptr.data == fast_ptr.data){
                slow_ptr.next = fast_ptr.next;
                fast_ptr = fast_ptr.next;
            }
            slow_ptr = slow_ptr.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);
        eliminateDuplicate(head);
        printList(head);

    }
}
