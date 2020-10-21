import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class ReverseLinkListInKGroups {

    public static Node createLinklist(Node head, int data){
        Node node = new Node(data);
        node.next = head;
        return node;
    }
    public static void printList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static int lengthOfList(Node head){
        int count = 0;
        Node node = head;
        while (node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    public static Node reverseInGroups(Node head, int K){
        if(head == null)
            return null;
        if(K == 1)
            return head;
        Node finalHead = null;
        boolean flag = false;
        Node curr = head.next;
        Node startTemp = head;
        Node nextt, prev, endTemp=null;
        while (curr != null){
            int count =1;
            prev = startTemp;
            if(curr != null)
                nextt = curr.next;
            else
                nextt = null;
            while(count < K && curr!= null){
                curr.next = prev;
                prev = curr;
                curr = nextt;
                if(nextt != null)
                    nextt = nextt.next;
                else
                    nextt = null;
                count++;
            }
            if(flag == false)
                finalHead = prev;
            flag = true;
            if(endTemp == null)
                endTemp = null;
            else
                endTemp.next = prev;
            endTemp = startTemp;
            startTemp = curr;
            if(curr != null)
                curr  = curr.next;
            else
                curr = null;
        }
        endTemp.next = startTemp;
        return finalHead;
    }

    public static Node reverseInKGroups(Node head, int K){
        if(head == null)
            return null;
        Node newHead = null;
        Node startTemp = null;
             startTemp = head;
        Node curr = head.next;
        Node prev = head;
        Node nextt;
        if(curr != null)
         nextt = curr.next;
        else
            nextt = null;
        int count = 1;
        while (count <K && curr != null){
            curr.next = prev;
            prev = curr;
            curr = nextt;
            if(nextt == null)
                nextt = null;
            else
                nextt = nextt.next;
            count++;
        }

        newHead = reverseInKGroups(curr, K);
        startTemp.next = newHead;
        return prev;
    }

    public static void main(String[] args) {
        Node head = null;
        Scanner sc = new Scanner(System.in);
        /*head = createLinklist(head, 8);
        head = createLinklist(head, 7);
        head = createLinklist(head, 6);
        head = createLinklist(head, 5);*/
        head = createLinklist(head, 4);
        head = createLinklist(head, 3);
        head = createLinklist(head, 2);
        head = createLinklist(head, 1);
        int K = sc.nextInt();
        if(K <= lengthOfList(head)) {
            /*Node finalHead = reverseInGroups(head, K);
            printList(finalHead);*/
            Node finalNode = reverseInKGroups(head, K);
            printList(finalNode);

        }

    }

}
