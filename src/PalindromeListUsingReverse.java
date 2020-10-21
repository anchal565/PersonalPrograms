public class PalindromeListUsingReverse {
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

    public void printList(){
        Node node=head;
        while (node!= null){
            System.out.print(node.data+" ");
            node=node.next;
        }


    }

    public boolean reverseList(Node head){
        boolean checkToDecideOddOrEven = false; // true if odd ; false if even
        Node node=head;
        //Node fast_ptr=head;
        int counter=0;
        while(node != null) {
            counter++;
            node = node.next;
        }
        System.out.println("Counter is : "+counter);
        if(counter%2 != 0)
            checkToDecideOddOrEven=true;

        System.out.println("checkToDecideOddOrEven : "+checkToDecideOddOrEven);
       Node slow_ptr=head;
        Node fast_ptr=head;
        while(fast_ptr != null && fast_ptr.next != null && fast_ptr.next.next != null){
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
        }
        Node mid_list = slow_ptr;
        System.out.println("Mid is : "+mid_list.data);
        Node prev = null;
        Node nextt = mid_list.next.next;
        Node curr = mid_list.next;
        while(curr != null){
            curr.next=prev;
            prev = curr;
            curr = nextt;
            if(nextt != null)
                nextt = nextt.next;
            else
                nextt = null;
        }
        Node head2=prev;
        mid_list.next=head2;

        Node check1 = head;
        Node check2 = head2;

        System.out.println("Head od first half is : "+check1.data);
        System.out.println("Head od second half is : "+check2.data);

        if(checkToDecideOddOrEven == true) {
            while (check1 != mid_list) {
            /*if(check1 == null && check2 != null)
                return false;
            if(check2 == null && check1 != null)
                return false;*/
                if (check1.data != check2.data)
                    return false;
                check1 = check1.next;
                check2 = check2.next;
            }
        }
        else
        {
            while (check1 != mid_list.next) {
            /*if(check1 == null && check2 != null)
                return false;
            if(check2 == null && check1 != null)
                return false;*/
                if (check1.data != check2.data)
                    return false;
                check1 = check1.next;
                check2 = check2.next;
            }
        }
        return true;

    }

    public static void main(String[] arg){
        PalindromeListUsingReverse nodeObj=new PalindromeListUsingReverse();
        nodeObj.push(1);
        nodeObj.push(2);
       /* nodeObj.push(2);
        nodeObj.push(4);*/
        /*nodeObj.push(2);
        nodeObj.push(4);*/


        nodeObj.printList();
        boolean isPalindrome = nodeObj.reverseList(head);
        if(isPalindrome==true)
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");


        //boolean check = obj.isPalindrome(head);
        /*if(check==true)
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");*/
    }
}
