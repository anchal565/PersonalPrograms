public class SwapTwoElementsInLinkList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }

    private static void swapElements(int position1, int position2){
        Node node1 = head;
        Node node2 = head;
        int count =1;
        while (node2 != null && count != Math.max(position1, position2)){
            if(position1 == position2) {
                System.out.println("No change");
                return;
            }
            if(count == Math.min(position1, position2))
                node1 = node2;
            node2 = node2.next;
            count++;
        }
        if(node2 == null){
            System.out.println("exceeds length of link list");
            return;
        }
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
    private static void printList(){
        Node node = head;
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        swapElements(1,1);
        printList();
    }
}
