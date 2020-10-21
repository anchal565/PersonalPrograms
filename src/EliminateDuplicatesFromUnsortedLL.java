import java.util.HashMap;

public class EliminateDuplicatesFromUnsortedLL {
    public static void printList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void eliminateDuplicateOptimisedSol(Node head){
        if(head == null)
            return;
        Node temp = head;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(temp.data, 0);
        while (temp != null && temp.next != null){
            if(hashmap.containsKey(temp.next.data)){
                temp.next = temp.next.next;
            }
            else {
                hashmap.put(temp.next.data, 0);
                temp = temp.next;
            }
        }
    }

    public static void eliminateDuplicate(Node head){
        if(head == null)
            return;
        Node slow_ptr = head;
        Node fast_ptr = head;
        while (slow_ptr != null){
            fast_ptr = slow_ptr;
            while (fast_ptr != null && fast_ptr.next != null){
                if(slow_ptr.data == fast_ptr.next.data){
                   fast_ptr.next = fast_ptr.next.next;
                }
                else
                    fast_ptr = fast_ptr.next;
            }
            slow_ptr = slow_ptr.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        /*eliminateDuplicate(head);
        printList(head);*/
        eliminateDuplicateOptimisedSol(head);
        printList(head);

    }
}
