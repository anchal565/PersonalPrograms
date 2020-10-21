public class LinkListReverse {

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

    public void reverse(){
        Node curr=head;
        Node nextt=head.next;
        Node prev=null;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=nextt;
            if(nextt==null)
                nextt=null;
            else
                nextt=nextt.next;

        }
        head=prev;
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] arg){

        LinkListReverse reverseObj= new LinkListReverse();
       reverseObj.push(1);
       reverseObj.push(2);
       reverseObj.push(3);
       reverseObj.printList();
       reverseObj.reverse();
       reverseObj.printList();
    }
}
