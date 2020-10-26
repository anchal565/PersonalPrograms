public class LinkedList_Intersection {

    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public static int length(Node head){
        int length = 0;
        Node temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }


    int intersectPoint(Node headA, Node headB)
    {
        // code here
        int length1 = length(headA);
        int length2 = length(headB);
        int k = Math.abs(length1 - length2);
        if(length1 < length2){
            int count = 0;
            Node tempHead = headB;
            while (count != k){
                count ++;
                tempHead = tempHead.next;
            }
            headB = tempHead;
        }
        else {
            int count = 0;
            Node tempHead = headA;
            while (count != k){
                count ++;
                tempHead = tempHead.next;
            }
            headA = tempHead;
        }
        if(headA == null)
            return -1;
        while(headA != null && headA.data != headB.data){
            headA = headA.next;
            headB = headB.next;
            if(headA == null)
                return -1;
        }
        return  headA.data;
    }

    public static void main(String[] args) {

    }
}
