//https://www.geeksforgeeks.org/print-left-view-binary-tree/
public class LeftViewOfBT {
    int maxLevel=-1;
    void leftView(TreeNode root)
    {
        // Your code here
        leftViewOfBT(root, 0);
    }
    void leftViewOfBT(TreeNode root, int level){
        if(root == null)
            return;
        if(maxLevel < level){
            System.out.print(root.data + " ");
            maxLevel++;
        }
        leftViewOfBT(root.left, level+1);
        leftViewOfBT(root.right, level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(3);
        //root.right.right = new TreeNode(-1);
        //root.left.left.left = new TreeNode(5);
        //root.left.left.right = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        //root.right.right.right = new TreeNode(8);
        LeftViewOfBT leftView = new LeftViewOfBT();
        leftView.leftView(root);
    }
}
