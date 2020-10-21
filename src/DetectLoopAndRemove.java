public class DetectLoopAndRemove {
    public static void printList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println();
    }
    private static int detectLoop(Node head){
        Node slow_ptr = head;
        Node fast_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null ){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if(slow_ptr == fast_ptr) {
                System.out.println("There is a loop");
                slow_ptr = head;
                while (slow_ptr.next != fast_ptr.next){
                    slow_ptr = slow_ptr.next;
                    fast_ptr = fast_ptr.next;
                }
                fast_ptr.next = null;
                return 1;
            }
        }
        System.out.println("No loop");
        return 0;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next;
        detectLoop(head);
        printList(head);

    }
}
