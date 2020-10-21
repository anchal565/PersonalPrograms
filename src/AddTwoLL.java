
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class AddTwoLL {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int value = 0;
        ListNode result = null, temp = null;
        while(l1 != null || l2 != null){
            if(l1 == null)
                value = carry + l2.val;
            else if(l2 == null)
                value = carry + l1.val;
            else
                value = carry + l1.val + l2.val;
            int rem = value%10;
            if(result == null){
                result = new ListNode(rem);
                temp = result;
            }
            else{
                temp.next = new ListNode(rem);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
            carry = value/10;

        }
        if(carry > 0)
            temp.next = new ListNode(carry);
        return result;

    }

    public static void printList(ListNode result){
        while (result != null){
            System.out.print(result.val +" ");
            result = result.next;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        /*l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/
        ListNode result = addTwoNumbers(l1, l2);
        printList(result);
    }
}
