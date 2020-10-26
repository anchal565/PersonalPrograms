public class MergeTwoSortedLinkList {
    static Node head1, head2;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next  = null;
        }
    }

    public static Node sortedMerge(Node headA, Node headB) {
        Node temp = null;
        Node newHead = null;
        while (headA != null && headB != null){
            if(headA.data < headB.data){
                if(newHead == null) {
                    temp = headA;
                    newHead = temp;
                    headA = headA.next;
                    //temp = temp.next;
                }
                else {
                    temp.next = headA;
                    temp = temp.next;
                    headA = headA.next;
                }
            }
            else {
                if(newHead == null){
                    temp = headB;
                    newHead = temp;
                    headB = headB.next;
                    //temp = temp.next;
                }
                else {
                    temp.next = headB;
                    temp = temp.next;
                    headB = headB.next;
                }
            }
        }
        if(headA == null && headB != null)
            temp.next = headB;
        else
            temp.next = headA;
        return newHead;
    }

    /*public static Node sortedMerge(Node headA, Node headB) {
        Node newHead = null;
        Node temp = null;
        while (headA != null && headB != null){
            if(headA.data < headB.data){
                temp = headA;
                if(newHead == null)
                    newHead = temp;
                temp = temp.next;
                if(headA.next == null){
                    temp = headB;
                    return temp;
                }
                else
                    headA = headA.next;
            }
            else {
                temp = headB;
                if(newHead == null)
                    newHead = temp;
                temp = temp.next;
                if(headB.next == null){
                    temp = headA;
                    return temp;
                }
                else
                    headB = headB.next;
            }
        }
        return  newHead;
    }*/

    public static void printList(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        head1 = new Node(5);
        /*head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);*/

        head2 = new Node(2);
        head2.next = new Node(6);
        /*head2.next.next = new Node(20);*/
        Node head = sortedMerge(head1, head2);
        printList(head);

    }
}
