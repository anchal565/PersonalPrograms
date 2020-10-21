import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        List<TreeNode> pathOfP = new ArrayList<>();
        List<TreeNode> pathOfQ = new ArrayList<>();
        TreeNode lca = null;
        findPath(root, p, pathOfP);
        findPath(root, q, pathOfQ);

        Iterator<TreeNode> i1 = pathOfP.iterator();
        Iterator<TreeNode> i2 = pathOfQ.iterator();
        while (i1.hasNext() && i2.hasNext()){
            TreeNode a1 = i1.next();
            TreeNode a2 = i2.next();
            if(a1 == a2)
                lca = a1;
        }
        return lca;

    }
    
    public boolean findPath(TreeNode root, TreeNode node, List<TreeNode> pathList){
        if(root == null){
            return false;
        }
        pathList.add(root);
        if(root == node)
            return true;
        boolean flag = findPath(root.left, node, pathList);
        if(flag == false)
            flag = findPath(root.right, node, pathList);
        if(flag == false)
            pathList.remove(pathList.size() -1);
        return flag;
    }

    public static void main(String[] args) {

    }
}
