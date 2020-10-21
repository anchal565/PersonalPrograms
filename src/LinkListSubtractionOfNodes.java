import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//1-2-3-4-5
//Output : -4 -> -2
public class LinkListSubtractionOfNodes {

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
        Node new_node=new Node(key);
        if(head==null)
            head=new_node;
        else{
            new_node.next=head;
            head=new_node;
        }
    }

    public void printList(){
        Node node=head;
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();

    }

    public void compute(){

        Node node=head;
    }

    public static void main(String[] ar){
      LinkedList<Integer> linkObject=new LinkedList<>();
        linkObject.push(1);
        linkObject.push(2);
        linkObject.push(3);
        linkObject.push(4);
        //linkObject.push(5);
        Iterator<Integer> iteratorrr=linkObject.iterator();

        int mid=linkObject.get(linkObject.size()/2);
        System.out.println("Middle index is : "+mid+" mid element is : "+linkObject.get(mid));

        Stack<Integer> stckObj=new Stack<Integer>();
        int i=mid;
        while(iteratorrr.hasNext()){
            if(i==linkObject.size())
                break;
            stckObj.push(linkObject.get(i));
            i++;
            iteratorrr.next();

        }
        System.out.println("Stack is ");
        Iterator<Integer> iteratorForStack=stckObj.iterator();
        System.out.println("Size of stack is : "+stckObj.size());
        while(iteratorForStack.hasNext()){
            System.out.print(iteratorForStack.next()+" ");
        }

        int j=0;
        int check=0;
        Iterator<Integer> newStack=stckObj.iterator();
        while (!stckObj.isEmpty()){
            System.out.println("In while");


                System.out.println("In if loop");
                check = stckObj.pop() - linkObject.get(j);
                System.out.println("Stack elements are : "+check);
                linkObject.set(j, check);
                j++;

        }
        System.out.println("Length of link list is : "+linkObject.size()+" j : "+j);

        while(j<linkObject.size()) {
            linkObject.set(j, null);
            j++;
        }
        System.out.println("Final list is : ");
        Iterator listIterator=linkObject.iterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next()+" ");
        }

    }

}
