public class LinkListDeletion {
    Node head;
   static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public void push(int data){
       Node node = new Node(data);
       node.next=head;
       head=node;
    }

    public static void main(String[] arg){
        LinkListDeletion listObject=new LinkListDeletion();
        listObject.push(6);
        listObject.push(7);
        listObject.push(8);
        listObject.push(9);
        listObject.printList();
        listObject.deleteKey(7);
        listObject.deleteKey(10);
        listObject.deleteByIndex(2);
        listObject.deleteByIndex(8);
    }

    public void printList(){
       Node node=head;
       while(node!=null){
           System.out.print(node.data+" ");
           node=node.next;
       }
        System.out.println();
    }


    //Delete using key
    public void deleteKey(int key){
       Node node=head;
       Node prev=null;
       if(key==node.data){
           head=node.next;
           return;
       }

       while(node.data!=key){
           prev=node;
           node=node.next;
       }
       prev.next=node.next;
       node.next=null;
        System.out.println("List after deletion is : ");
       printList();

    }

    //Delete using index
    public void deleteByIndex(int index){
       Node node=head;
       Node prev=null;
       int countIndex=0;
       if(index==0){
           head=node.next;
       }
       while(countIndex!=index){
        prev=node;
        node=node.next;
        countIndex++;
       }
       if(countIndex==index){
           prev.next=node.next;
           node.next=null;
       }
       else if(countIndex>index)
           System.out.println("Index exceeding length");

        System.out.println("list after delete through index is : ");
        printList();

    }
}
