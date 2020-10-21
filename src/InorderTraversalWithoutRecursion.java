import java.util.*;

public class InorderTraversalWithoutRecursion {
    static Node root;
    static class Node {
        int data;
        Node left, right;
        //boolean flag;

        Node(int d) {
            data = d;
            left = right = null;
         //   flag = false;
        }
    }

    public static void inOrderTraversalUsingStack(Node node){
        List<Integer> list = new ArrayList<>();
        if(node == null)
            return;


        Stack<Map<String,Object>> stack = new Stack<>();
        Map<String,Object> m = new HashMap<>();
        m.put("node",node);
        m.put("flag",false);
        stack.push(m);
        /*
        Stack<HashMap<Node, Boolean>> stack = new Stack<>();
        HashMap<Node, Boolean> hashMap = new HashMap<>();
        hashMap.put(node, false);
        stack.push(hashMap);*/
        while ((!stack.isEmpty())){
            Map<String,Object> m1 = stack.peek();

            Node tempNode = (Node)m1.get("node");
            while( (tempNode.left == null && tempNode.right == null) || ((boolean)m1.get("flag") == true) ) {
                System.out.print(tempNode.data + " ");
                stack.pop();
                if(stack.isEmpty())
                    return;
                else {
                    m1 = stack.peek();
                    tempNode = (Node)m1.get("node");
                }

            }
            if(stack.isEmpty())
                return;
            m1 = stack.pop();
            tempNode = (Node)m1.get("node");
            if(tempNode.right != null) {
                m1=new HashMap<>();
                m1.put("node",tempNode.right);
                m1.put("flag",false);
                stack.push(m1);
            }
            m1=new HashMap<>();

            m1.put("node",tempNode);
            m1.put("flag",true);
            stack.push(m1);
            //tempNode.flag=true;
            if(tempNode.left != null) {
                m1=new HashMap<>();

                m1.put("node",tempNode.left);
                m1.put("flag",false);
                stack.push(m1);
            }
        }
    }

    public static void main(String[] ar){
        /*root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);*/
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right=new Node(6);
        root.right.right.left=new Node(7);


        inOrderTraversalUsingStack(root);
    }
}
