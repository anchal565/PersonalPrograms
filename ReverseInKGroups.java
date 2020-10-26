public class ReverseInKGroups {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node reverse(Node node, int k){
        //Node initialEnd = null;
        Node initialStart = null;
        if(node == null)
            return null;
        int count = 1;
        int noOfGroups = 0;
        Node prev = node;
        Node current = node.next;
        Node nextt = null;
        if(node.next == null || node.next.next == null)
            nextt = null;
        else
        nextt = node.next.next;
        initialStart = node;
        Node secondStart = null;
        while(prev != null){
            secondStart = prev;
            count = 1;
            while(count < k && current != null){
                current.next = prev;
                prev = current;
                current = nextt;
                if(nextt == null || nextt.next == null){
                    nextt = null;
                }
                else
                    nextt = nextt.next;
                count = count + 1;
            }

            noOfGroups = noOfGroups + 1;
            if(noOfGroups == 1) {
                head = prev;
            }
            else if(noOfGroups > 1){
                initialStart .next = prev;
                initialStart = secondStart;
            }
            if(current != null) {
                prev = current;
                if(nextt == null)
                    current = null;
                else
                    current = nextt;
                if(nextt == null)
                    nextt = null;
                else
                    nextt = nextt.next;
            }
            else {
                secondStart.next = null;
                return head;
            }
        }
        return head;
    }


    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        /*head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);*/
        //head.next.next.next.next.next.next.next = new Node(8);
        //head.next.next.next.next.next.next.next.next = new Node(9);
        reverse(head, 9);
        printList(head);

    }
}
