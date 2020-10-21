public class LengthInLinkLIst {

    Node head;
    class Node{
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

    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    //Iterative Approach
    public int findLength(){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;


        }
        System.out.println();
        return count;
    }

    //Recursive Approach
    public int findLengthByRecursion(int count, Node node){
        if(node==null)
            return count;
        else{
            System.out.println("Count is : "+count);
            return findLengthByRecursion(count +1, node.next);

        }
        //return count;

    }

    public static void main(String[] arg){
        LengthInLinkLIst objInNode=new LengthInLinkLIst();

        objInNode.push(1);
        objInNode.push(2);
        objInNode.push(3);
        objInNode.push(4);
        objInNode.push(5);
        objInNode.push(6);
        objInNode.push(7);
        objInNode.push(8);

        objInNode.printList();

        int length=objInNode.findLength();
        System.out.println("Length by iterative approach is : " +length);

        length=objInNode.findLengthByRecursion(0, objInNode.head);
        System.out.println("Length by recursive approach is : " +length);
    }
}
