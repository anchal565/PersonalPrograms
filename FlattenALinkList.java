public class FlattenALinkList {

    static Node head;
    static class Node{
        int data;
        Node next, down;
        Node(int d){
            data = d;
            next = down = null;
        }
    }


    public static Node mergeList(Node list1, Node list2){
        Node temp = null;
        Node newHead = null;
        while (list1 != null && list2 != null){
            if(list1.data < list2.data){
                if(newHead == null) {
                    temp = list1;
                    newHead = temp;
                    list1 = list1.down;
                    //temp = temp.next;
                }
                else {
                    temp.down = list1;
                    temp = temp.down;
                    list1 = list1.down;
                }
            }
            else {
                if(newHead == null){
                    temp = list2;
                    newHead = temp;
                    list2 = list2.down;
                    //temp = temp.next;
                }
                else {
                    temp.down = list2;
                    temp = temp.down;
                    list2 = list2.down;
                }
            }
        }
        if (list1 == null && list2 != null) {
            while (list2 != null) {
                temp.down = list2;
                list2 = list2.down;
                temp = temp.down;
            }
        }
        else {
            while (list1 != null) {
                temp.down = list1;
                list1 = list1.down;
                temp = temp.down;
            }
        }
        return newHead;
    }

    public static Node flatten(Node root) {
        Node secondHead = root.next;
        Node newNode = root;
        Node temp = null;
        while (secondHead != null){
            temp = secondHead.next;
            newNode = mergeList(newNode, secondHead);
            secondHead = temp;
        }
        return newNode;
    }

    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        head = new Node (2);
        head.next = new Node(4);
        head.down = new Node(4);
        head.down.down = new Node(5);
        head.next.down = new Node (6);
        head.next.next = new Node(6);
        head.next.next.down = new Node(7);
        Node newHead = flatten(head);
        printList(newHead);
    }
}
