//Leet- challenge June 2nd,2020
// Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
//
//Given linked list -- head = [4,5,1,9]
public class DeleteNodeInLL {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        while(temp.next.next != null){
            temp.val = temp.next.val;
            temp = temp.next;
        }
        temp.val = temp.next.val;
        temp.next = null;

    }
    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head. next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        DeleteNodeInLL deleteNode = new DeleteNodeInLL();
        deleteNode.deleteNode(head.next);
        deleteNode.printList(head);
    }
}
