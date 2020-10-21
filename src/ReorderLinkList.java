//https://leetcode.com/explore/featured/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3430/
//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
public class ReorderLinkList {
    public void reorderList(ListNode head) {
        ListNode mid = midPtr(head);
        ListNode newMid = null;
        if(mid != null){
            newMid = mid.next;
            mid.next = null;
        }
        newMid = rearrange(newMid);
        merge(head, newMid);
    }

    public void merge(ListNode temp1, ListNode temp2){
        boolean flag = true;
        ListNode finalHead = temp1;
        if(temp1 != null)
            temp1 = temp1.next;
        while(temp1 != null || temp2 != null){
            if(flag == false){
                finalHead.next = temp1;
                temp1 = temp1.next;
            }
            else{
                finalHead.next = temp2;
                temp2 = temp2.next;
            }
            finalHead = finalHead.next;
            flag = !flag;
        }
    }

    public ListNode midPtr(ListNode head){
        ListNode fastptr = head;
        ListNode slowptr = head;
        while(fastptr != null && fastptr.next!= null && fastptr.next.next!= null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        return slowptr;
    }

    public ListNode rearrange(ListNode head){
        ListNode curr = head, prev = null, nextt;
        while(curr != null){
            nextt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextt;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ReorderLinkList obj = new ReorderLinkList();
        obj.reorderList(list);

    }
}
