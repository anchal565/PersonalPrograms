public class RotateLLByNElements {
    public static Node rotate(int n, Node head){
        if(head == null)
            return null;
        int length = length(head);
        if(n == length)
            return head;
        int count =1;
        n = length-n;
        Node fast_ptr = head;
        Node temp = head;
        while(fast_ptr != null && count != n){
            fast_ptr = fast_ptr.next;
            count++;
        }
        temp = fast_ptr;
        System.out.println("Fast ptr is at : "+fast_ptr.data);
        while (temp.next != null){
            temp = temp.next;
        }
        Node newHead = fast_ptr.next;
        temp.next = head;
        fast_ptr.next = null;
        return newHead;
    }
    public static int length(Node head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public static Node rotate2(int n, Node head){
        if(head == null)
            return null;
        Node slow_ptr = head;
        Node fast_ptr = head;
        int count = 1;
        while(fast_ptr != null && count <= n){
            fast_ptr = fast_ptr.next;
            count++;
        }
        if(fast_ptr == null)
            return head;
        System.out.println("Fast ptr is at : "+fast_ptr.data);
        while (fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
        }
        Node newHead = slow_ptr.next;
        fast_ptr.next = head;
        slow_ptr.next = null;
        return newHead;
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
        Node head1 = new Node(2);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(20);
        head1.next.next.next.next = new Node(25);
        //Node newHead = rotate(5,head1);
        Node newHead = rotate2(4,head1);
        printList(newHead);
    }
}
