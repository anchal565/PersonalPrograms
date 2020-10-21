public class MergeSortInLL {

    public static Node merge(Node head1, Node head2){
        Node newHead = null, temp = null;
        while (head1 != null && head2 != null){
            if(head1.data < head2.data){
                if(newHead == null) {
                    newHead = new Node(head1.data);
                    temp = newHead;
                    head1 = head1.next;
                }
                else {
                    temp.next = new Node(head1.data);
                    temp = temp.next;
                    head1 = head1.next;
                }
            }
            else {
                if(newHead == null) {
                    newHead = new Node(head2.data);
                    temp = newHead;
                    head2 = head2.next;
                }
                else {
                    temp.next = new Node(head2.data);
                    temp = temp.next;
                    head2 = head2.next;
                }
            }
        }
        if(head1 == null){
            temp.next = head2;
        }
        else {
            temp.next = head1;
        }
        return newHead;
    }

    public static Node mergeSort(Node head){
        if(head == null)
            return null;
        Node mid = mid(head);
        Node right = mid.next;
        mid.next = null;
        if (head != null) {
            mergeSort(head);
            mergeSort(right);
            return merge(head, right);
        }
        return null;
    }
    public static Node mid(Node head){
        if(head == null)
            return null;
        Node fast_ptr = head;
        Node slow_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        return slow_ptr;
    }

    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(20);
        head1.next = new Node(15);
        head1.next.next = new Node(30);
        /*head1.next.next.next = new Node(10);
        head1.next.next.next.next = new Node(5);*/
        Node newHead = mergeSort(head1);
        printList(newHead);
    }
}
