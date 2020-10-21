import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalEasy {
    public List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        levelTraversalHelp(root, 0, resultList);
        return resultList;
    }
    public void levelTraversalHelp(TreeNode root, int level, List<List<Integer>> resultList){
        if(root == null)
            return;
        if(resultList.size() <= level){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(root.data);
            resultList.add(level, tempList);
        }
        else{
            List<Integer> tempList = resultList.get(level);
            tempList.add(root.data);
        }
        levelTraversalHelp(root.left, level+1, resultList);
        levelTraversalHelp(root.right, level+1, resultList);
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
        LevelOrderTraversalEasy levelOrderTraversal = new LevelOrderTraversalEasy();
        levelOrderTraversal.levelTraversal(root);
    }
}
