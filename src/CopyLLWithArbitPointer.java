class NodeNew{
    int data;
    NodeNew next, arbit;
    NodeNew(int data){
        this.data = data;
        arbit = null;
        next = null;

    }
}

public class CopyLLWithArbitPointer {

    public static NodeNew copyLL(NodeNew head){
        NodeNew temp = head;
        NodeNew newHead = null;
        NodeNew temp2 = null;
        while (temp != null){
            if(newHead == null){
                newHead = new NodeNew(temp.data);
                temp = temp.next;
                temp2 = newHead;
            }
            else {
                temp2.next = new NodeNew(temp.data);
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        NodeNew head1 = new NodeNew(1);
        head1.next = new NodeNew(2);
        head1.arbit = head1;
        head1.next.next = new NodeNew(3);
        head1.next.arbit = head1.next.next;
        head1.next.next.next = new NodeNew(4);
        head1.next.next.next.next = new NodeNew(5);
        head1.next.next.next.arbit = head1.next;
        head1.next.next.next.next.arbit = head1.next.next.next;
        NodeNew newHead = copyLL(head1);
    }

    }
