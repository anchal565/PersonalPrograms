public class DetectLoopInLinkList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    /*public static int detectLoop(Node head){
        if(head == null)
            return 0;
        Node slow_ptr = head;
        Node fast_ptr = head;
        boolean flag = false;
        while (slow_ptr != null && fast_ptr != null && (fast_ptr != slow_ptr || ( fast_ptr == slow_ptr && flag ==false))){
            flag = true;
            if(slow_ptr.next != null){
                slow_ptr = slow_ptr.next;
            }
            else
                slow_ptr = null;
            if(fast_ptr.next != null && fast_ptr.next.next != null)
                fast_ptr = fast_ptr.next.next;
            else
                fast_ptr = null;
        }
        if(fast_ptr == slow_ptr && flag == true)
            return 1;
        else
            return 0;
    }*/

    public static int detectLoop(Node head){
        if(head == null)
            return 0;
        Node slow_ptr = head;
        Node fast_ptr = head;
        while (fast_ptr != null && slow_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if(slow_ptr == fast_ptr)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;
        int result=detectLoop(head);
        System.out.println(result);
    }
}
