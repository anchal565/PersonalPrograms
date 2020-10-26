public class ImplementQueueUsingLL {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static void push(int a){
        Node temp = head;
        if(head == null) {
            head = new Node(a);
            return;
        }
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(a);
    }

    public static int pop(){
        if(head == null)
            return -1;
        Node temp = head;
        int key = temp.data;
        head = temp.next;
        return key;
    }

    public static void main(String[] args) {

    }
}
