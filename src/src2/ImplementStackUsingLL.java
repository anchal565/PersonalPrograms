public class ImplementStackUsingLL {
    static StackNode top;
    static class StackNode{
        int data;
        StackNode next;
        StackNode(int d){
            data = d;
            next = null;
        }
    }

    public static void push(int a) {
        StackNode temp = top;
        StackNode newNode = new StackNode(a);
        if(top == null){
            top = newNode;
        }
        else {
            newNode.next = temp;
            top = newNode;
        }
    }

    public static int pop() {
        StackNode temp = top;
        if(top == null)
            return -1;
        int key = temp.data;
        top = temp.next;
        return key;

    }
}
