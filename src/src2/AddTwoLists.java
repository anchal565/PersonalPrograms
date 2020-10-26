public class AddTwoLists {
    static Node head1, head2;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node addTwoLists(Node first, Node second) {
        Node temp = null;
        Node newHead = temp;
        int carry = 0;
        int firstData = 0;
        int secondData = 0;
        int count = 0;
        int maxLength = Math.max(length(first), length(second));
        while (count <= maxLength){
            carry = 0;
            if(first == null)
                firstData = 0;
            else firstData = first.data;
            if(second == null)
                secondData = 0;
            else
                secondData = second.data;
            int check = firstData + secondData + carry;
            if(firstData == 0 && secondData == 0 && carry == 0 && count == maxLength)
                return newHead;
            if(check < 10){
              Node tempNode = new Node(check);
                if(newHead == null) {
                    newHead = tempNode;
                    temp = newHead;
                }
                else {
                    temp.next = tempNode;
                    temp = temp.next;
                }
            }
            else {
                carry = carry(firstData , secondData,carry);
                Node tempNode = new Node(check%10);
                if(newHead == null) {
                    newHead = tempNode;
                    temp = newHead;
                }
                else {
                    temp.next = tempNode;
                    temp = temp.next;
                }
            }
            if(first != null)
                first = first.next;
            if(second != null)
                second = second.next;
            count++;

        }
        return newHead;
    }

    public static int carry(int a, int b, int carry){
        return (a+b+carry)/10;
    }

    public  static int length(Node head){
        Node temp = head;
        int count = 0;
        while (temp != null){
            count ++;
            temp = temp.next;
        }
        return count;
    }

    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        head1 = new Node(9);
        head1.next = new Node(9);

        head2 = new Node(9);
        Node newHead = addTwoLists(head1, head2);
        printList(newHead);

    }
}
