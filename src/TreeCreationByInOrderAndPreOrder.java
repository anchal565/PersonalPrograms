
public class TreeCreationByInOrderAndPreOrder {
    static Node root;
    static int[] inOrder;
    static int[] preOrder;

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    TreeCreationByInOrderAndPreOrder() {
        root = null;
    }

    public static void main(String[] arg) {
        TreeCreationByInOrderAndPreOrder treeObj = new TreeCreationByInOrderAndPreOrder();
        inOrder = new int[]{4, 2, 5, 1, 6, 3};
        preOrder = new int[]{1, 2, 4, 5, 6, 3};

        int i = 0;
        while (i < preOrder.length) {
            selectInOrderIndex(i);
            i++;
        }
        //treeCreation(0,root);
    }

    public static void selectInOrderIndex(int i){
        int index=0;
        int preOrderValue = preOrder[i];
        Node node = new Node(preOrderValue);
        for(int j=0; j<inOrder.length; j++){
            if(inOrder[j] == preOrderValue)
                index = j;

        }

    }
}
/*
    public static void selectInOrderIndex(int preOrderIndex){

        int preOrderVal = preOrder[preOrderIndex];
        Node node = null;
        if(preOrderIndex == 0) {
            root = new Node(preOrderVal);
            treeCreation(node, preOrderVal);
        }
        else {
            node = new Node(preOrderVal);
            treeCreation(node, preOrderVal);
        }

    }

    public static Node treeCreation(Node node, int preOrderVal){
        int i=0;
        for(i=0;i<inOrder.length;i++){
            if(inOrder[i] == preOrderVal)
                break;
        }
        node.left = treeCreation(0, i-1);
        node.right = treeCreation(i+1, inOrder.length);
    }

    */
/*public static void treeCreation(int preOrderIndex, Node node, int start_index, int end_index){
            Node nodeCre = new Node(preOrder[preOrderIndex]);
            nodeCre.left=treeCreation();

    }*//*

}
*/
