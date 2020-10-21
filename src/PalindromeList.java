import java.util.Iterator;
import java.util.Stack;

public class PalindromeList {

   static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
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

    public boolean isPalindrome(Node node){

        Stack<Integer> stackObj=new Stack<>();
        Node temp=node;
        while(temp!=null){
            stackObj.push(temp.data);
            temp=temp.next;
        }
       /* Iterator<Integer> iterator = stackObj.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();*/
        Node temp2 = node;
        while (temp2 != null){
            if(stackObj.pop() != temp2.data)
                return false;
            temp2=temp2.next;
        }
        return true;

    }



    public void printList(){
        Node node=head;
        while (node!= null){
            System.out.print(node.data+" ");
            node=node.next;
        }


    }
    public static void main(String[] arg){
        PalindromeList nodeObj=new PalindromeList();
        nodeObj.push(1);
        nodeObj.push(5);
        nodeObj.push(5);
        nodeObj.push(1);

        nodeObj.printList();
        PalindromeList obj=new PalindromeList();



        boolean check = obj.isPalindrome(head);
        if(check==true)
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");
    }
}
