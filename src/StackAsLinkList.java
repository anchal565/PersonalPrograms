public class StackAsLinkList {

    StackNode root;
    class StackNode{
        int data;
        StackNode next;
        StackNode(int d){
            data=d;
            next=null;
        }
    }

    public void push(int key){
        StackNode new_node=new StackNode(key);
        if(root==null)
            root=new_node;
        else
        {
            new_node.next=root;
            root=new_node;
        }
    }

    public int pop(){
        if(root==null){
            System.out.println("No elements present to delete");
            return -1;
        }
        else{
            int popped=root.data;
            root=root.next;
            return popped;
        }
    }

    public void printList(){
        StackNode node=root;
        while(node!=null){
            System.out.println(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }

    public static void main(String[] arg){
        StackAsLinkList stackObj=new StackAsLinkList();
        stackObj.push(1);
        stackObj.push(2);
        stackObj.push(3);
        stackObj.push(4);
        stackObj.push(5);
        stackObj.push(6);
        stackObj.printList();

        stackObj.pop();
        stackObj.printList();
    }
}
