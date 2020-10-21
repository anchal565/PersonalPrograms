import java.util.ArrayList;
import java.util.List;

public class RightViewOfBT {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideElements = new ArrayList<Integer>();
        rightSideElements = rightSideView(root, 0, rightSideElements);
        return rightSideElements;
    }
    public List<Integer> rightSideView(TreeNode root, int level, List<Integer> rightSideElements) {
        if(root == null){
            return rightSideElements;
        }
        if(rightSideElements.size() == level){
            rightSideElements.add(level, root.data);
        }
        rightSideView(root.right, level+1, rightSideElements);
        rightSideView(root.left, level+1, rightSideElements);
        return rightSideElements;
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
        RightViewOfBT leftView = new RightViewOfBT();
        leftView.rightSideView(root);
    }
}
