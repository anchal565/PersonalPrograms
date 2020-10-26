public class RemoveLoopInLinkList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static void removeTheLoop(Node head){
        if(head == null)
            return;
        Node slow_ptr = head;
        Node fast_ptr = head;
        Node start_of_loop = null;
        while(slow_ptr != null && fast_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if(slow_ptr == fast_ptr){
                Node temp = slow_ptr;
                Node start_temp = head;
                Node prev = null;
                while(temp != start_temp){
                    prev = temp;
                    temp = temp.next;
                    start_temp = start_temp.next;
                }
                start_of_loop = temp;
                prev.next = null;
                //findEndOfLoop(start_of_loop);
                break;
            }
        }
    }

    public static void findEndOfLoop(Node start_node){
        Node temp = start_node;
        while(temp.next != start_node)
            temp = temp.next;
        temp.next = null;
    }

    public static void printList(){
        Node temp = head;
        while ((temp!= null)){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;
        removeTheLoop(head);
        printList();
        /*int result=detectLoop(head);
        if(result == 1)
            removeTheLoop(head);*/
        //System.out.println(result);
    }
}
