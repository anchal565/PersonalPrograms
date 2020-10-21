public class LinkListCreation {
    Node head;

     static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public static void main(String[] ar){
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);

        LinkListCreation linkObject = new LinkListCreation();
        linkObject.head=node1;
        node1.next=node2;
        node2.next=node3;
        printList(linkObject.head);
    }

    public static void printList(Node head){
         Node node=head;
         while(node!=null){
             System.out.println(node.data + " ");
             node=node.next;
         }
    }
}
