import java.util.Scanner;

public class MiddleInLinkList {
    static Node root;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public static void push(int element){
        Node node = new Node(element);
        if(root == null)
            root = node;
        else{
            Node tempNode = root;
           /* node.next = root;
            root = node;*/
           while(tempNode.next!=null){
               tempNode=tempNode.next;
           }
           tempNode.next = node;
        }
    }

    int count(Node head){
        Node temp = head;
        int count =0;
        while(temp != null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    int getMiddle(Node head){
        Node slow_ptr = head;
        Node fast_ptr = head;
        while (fast_ptr.next != null && fast_ptr.next.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        if(count(head)%2 == 0)
        return slow_ptr.next.data;
        else
            return slow_ptr.data;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int N = sc.nextInt();
            for(int i=0; i<N;i++) {
                push(sc.nextInt());
            }
            /*System.out.println("Print link list :");
            Node node = root;
            while(node!= null){
                System.out.print(node.data +" ");
                node=node.next;
            }*/
            MiddleInLinkList middleObj = new MiddleInLinkList();
            System.out.println(middleObj.getMiddle(root));
            /*LinkedList linkedList = new LinkedList();
            for(int i=0; i<N;i++)
                linkedList.add(sc.nextInt());*/
            //linkedList.

        }
    }
}
