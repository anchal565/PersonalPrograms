public class EvenAfterOddInLL {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }
    public static void printList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println();
    }
    private static void evenAfterOdd(){
        Node indexNode = head;
        Node temp = head;
        while (temp != null){
            if(temp.data %2 != 0){
                int var = temp.data;
                temp.data = indexNode.data;
                indexNode.data = var;
                indexNode = indexNode.next;
            }
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(9);
        head.next.next.next = new Node(7);
        //head.next.next.next.next = new Node(2);
        evenAfterOdd();
        printList(head);

    }
}
