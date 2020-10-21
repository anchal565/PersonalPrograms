import java.util.HashMap;

public class IntersectionOf2LL {

    public static Node intersectPoint(Node head1, Node head2){
        if(head1 == null || head2 == null)
            return null;
        HashMap<Node, Integer> hashMap = new HashMap<Node,Integer>();
        Node temp = head1;
        while (temp != null){
            hashMap.put(temp, 1);
            temp = temp.next;
        }
        temp = head2;
        while (temp != null){
            if(hashMap.get(temp) != null){
                return temp;
            }
            else {
                temp = temp.next;
            }
        }
        return null;

    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(7);
        head2.next.next.next = head1.next;
        Node intersectNode = intersectPoint(head1, head2);
        System.out.println(intersectNode.data);
    }
}
