import java.util.HashSet;

public class DetectLoopAndFindLength {

    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }

    public void push(int key){
        Node node=new Node(key);
        if(head==null)
            head=node;
        else{
            node.next=head;
            head=node;
        }

    }

    public boolean detectLoop(){
        Node slow = head;
        Node fast = head;
        boolean loop=false;
        while(fast!=null){
            if(fast.data==slow.data && fast !=head){
                //System.out.println("Loop exists");
                loop_node=fast;
                loop=true;
                return loop;
            }
            else{
                fast=fast.next.next;
                slow=slow.next;
            }
        }
        return loop;

    }

    public void detectLoopUsingHashing(){
        Node node=head;
        HashSet<Node> hashObj=new HashSet<Node>();
        while(node!=null){
            if(hashObj.contains(node)){
                System.out.println("Loop exists checked via Hashing");
                return;
            }
            hashObj.add(node);
            node=node.next;

        }
        if(node==null)
            System.out.println("Loop does not exist");

    }

    public int countNoOfNodeInLoop(){
        Node node=loop_node;
        int count=0;
        System.out.println("Loop node is : "+loop_node.data);
        while(node!=loop_node || count==0){
            System.out.println("Hi");
            count++;
            node=node.next;
            System.out.println("Hiiii "+count);
        }
        return count;
    }

    public Node removeLoop(){
        Node node = loop_node;
        Node temp=head;
        System.out.println("Loop node is : "+node.data+" temp is : "+temp.data);
        while(node.next.data!=temp.next.data){
            node=node.next;
            temp=temp.next;
        }
        Node last_node=node;
        return last_node;
    }

    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static Node loop_node=null;
    public static void main(String[] arg){
        DetectLoopAndFindLength detectObj= new DetectLoopAndFindLength();
        detectObj.push(1);
        detectObj.push(2);
        detectObj.push(3);
        detectObj.push(4);
        System.out.println("TRYYY : "+head.next.next.next.data);
        Node node5= new Node(5);
        head.next.next.next.next=node5;
        node5.next=head.next;

        //detectObj.printList();

        detectObj.detectLoopUsingHashing();

        boolean loop=detectObj.detectLoop();
        if(loop==true) {
            System.out.println("Loop exists");
            int countOfLoop=detectObj.countNoOfNodeInLoop();
            System.out.println("No. of nodes is : "+countOfLoop);
            Node last_node=detectObj.removeLoop();
            System.out.println("Last node is "+ last_node.data);
            last_node.next=null;
            detectObj.printList();
        }
        else
            System.out.println("Loop does not exist");



    }






}
