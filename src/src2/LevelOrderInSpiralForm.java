public class LevelOrderInSpiralForm {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }

    static boolean check = false;
    private static int height(Node node){
        int lheight =0, rheight =0;
        if(node == null)
            return 0;
        else{
            lheight = 1 + height(node.left);
            rheight = 1 + height(node.right);
        }
        if(lheight >rheight)
            return lheight;
        else
            return rheight;
    }

    private static void printStatic(Node node){
        for(int i=0;i<height(node); i++){
            printSpiralMethod(node, i);
            check = !check;
        }
    }

    private static void printSpiralMethod(Node node, int level){
        if(node == null)
            return;
        if(level == 0){
            System.out.print(node.data +" ");
            return;
        }
        else{
            if(check == true) {
                printSpiralMethod(node.left, level-1);
                printSpiralMethod(node.right, level-1);

                //check = true;
            }
            else {
                printSpiralMethod(node.right, level-1);
                printSpiralMethod(node.left, level-1);
            }


        }
    }

    public static void main(String[] args) {
        root = new Node(20);
        root.left= new Node(8);
        //root.left.left = new Node(5);
        //root.left.left.left = new Node(15);
        root.right = new Node(25);
        //root.left.right = new Node(12);
        //root.left.right.right = new Node(7);
       // root.right.left = new Node(22);
        //root.right.right = new Node(30);
        printStatic(root);
    }
}
