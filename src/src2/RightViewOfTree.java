public class RightViewOfTree {

    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public static int height (Node node){
        int lheight = 0;
        int rheight = 0;
        if(node == null)
            return 0;
        else
        {
            lheight = 1 + height(node.left);
            rheight = 1 + height(node.right);
        }
        if(lheight > rheight)
            return lheight;
        else
            return rheight;

    }

    public static boolean rightView(Node node, int level){
        boolean flag = false;
        if(node == null)
            return flag;
        if(level == 1) {
            System.out.print(node.data + " ");
            flag = true;
            return flag;
        }
        else{
            flag = rightView(node.right, level-1);
            if(flag == false)
                rightView(node.left, level-1);
        }
        return flag;

    }



    public static void main(String[] ar){
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        /*root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.right.left = new Node(6);
        root.left.left.right.right = new Node(7);*/

        /*root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);*/

        System.out.println("Height of a tree is : "+height(root));
        int i=1;
        while(i<=height(root)){
            rightView(root, i);
            i++;
        }
    }
}
