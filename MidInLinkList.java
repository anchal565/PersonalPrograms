public class MidInLinkList {
    Node head;
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
        if(head==null){
            head=node;
        }
        else{
            /*//Insert at beginning
            node.next=head;
            head=node;*/

            //Insert at end
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }
    }

    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
        System.out.println();
    }


    public Node midOfList(){

        Node prev=head;
        Node node=head;
        while(node!=null && node.next!=null && node.next.next!=null){
            prev=prev.next;
            node=node.next.next;
        }
        /*if(node!=null && node.next==null )
            return prev;*/


        return prev;
    }

    /*public void midOfList1(){
        Node prev=head;
        Node node=head;
        while(node.next!=null && node!=null){
            prev=node.next;
            node=node.next.next;
        }
    }*/

    public static void main(String[] arg){
        MidInLinkList midObject = new MidInLinkList();
        midObject.push(1);
        midObject.push(2);
        midObject.push(3);
        midObject.push(4);
        midObject.push(5);

        midObject.printList();

        Node node=midObject.midOfList();
        System.out.println("Mid of list is : "+node.data);
    }

}
