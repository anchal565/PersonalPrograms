public class MidPointOfLinkList {
    static Node head;
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    private static void midPointOfLL(){
        Node slow_ptr = head;
        Node fast_ptr = head;
        while(fast_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        System.out.println("Mid point is : "+slow_ptr.data);
    }
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        midPointOfLL();
    }
}
