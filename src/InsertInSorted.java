public class InsertInSorted {

    public static Node insertInSorted(Node head, Node new_node){
        Node newHead = head;
        if(head == null)
            return newHead=new_node;

        while (head != null && head.next != null && head.next.data < new_node.data){
            head = head.next;
        }
        //if(head == null)
        new_node.next = head.next;
        head.next = new_node;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        //head.next.next.next.next.next = new Node(6);
        insertInSorted(head, new Node(6));
        printList(head);
    }
}
