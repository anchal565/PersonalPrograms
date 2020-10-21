import java.util.*;

class TreeNode{
    TreeNode left,right;
    int data;
    TreeNode(int d){
        data = d;
    }
}
public class LevelOrderTraversalInZigZag {

    static List<List<Integer>> li = new ArrayList<>();
    /*public static void levelOrderTraversal(TreeNode root, int level){
        if(root == null){
            return;
        }
        else {
            if(li.size() < level+1){
                List<Integer> subList = new ArrayList<>();
                li.add(subList);
            }
            if(level%2 == 0){
                levelOrderTraversal(root.right, level+1);
                levelOrderTraversal(root.left, level+1);
            }
            else {
                levelOrderTraversal(root.left, level + 1);
                levelOrderTraversal(root.right, level + 1);
            }
            if(li.get(level) != null){
                List<Integer> subList = li.get(level);
                subList.add(root.data);
            }
            else {
                List<Integer> subList = new ArrayList<>();
                subList.add(root.data);
                li.add(subList);
            }
        }
    }*/

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        boolean flag = false;
        System.out.println("Height is : "+height(root));
        for(int i=0; i<height(root); i++){
            List<Integer> subList = new ArrayList<>();
            subList = nodesPerLevel(root, i, subList, flag);
            list.add(subList);
            flag = !flag;
        }
        return list;
    }

    public static List<Integer> nodesPerLevel(TreeNode root, int level, List<Integer> subList, boolean flag){
        if(root == null)
            return subList;
        if(level == 0){
            subList.add(root.data);
            return subList;
        }
        if(flag == true){
            nodesPerLevel(root.right, level-1, subList, flag);
            nodesPerLevel(root.left, level-1, subList, flag);
        }
        else{
            nodesPerLevel(root.left, level-1, subList, flag);
            nodesPerLevel(root.right, level-1, subList, flag);
        }
        return subList;
    }

    public static int height(TreeNode root){
        int lheight =0, rheight =0;
        if(root == null)
            return 0;
        lheight = 1 + height(root.left);
        rheight = 1 + height(root.right);
        return (lheight>rheight ? lheight:rheight);
    }

    public static List<List<Integer>> zigZagViaQueue(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        boolean flag = true;
        List<List<Integer>> list = new ArrayList<>();
        while (stack1 != null || stack2!= null){
            TreeNode temp = null;
            List<Integer> subList = new ArrayList<>();
            if(!stack1.isEmpty()) {
                temp = stack1.peek();
                if (flag == true) {
                    stack2.push(temp.left);
                    stack2.push(temp.right);
                } else {
                    stack2.push(temp.right);
                    stack2.push(temp.left);
                }
                subList.add(temp.data);
                list.add(subList);
                flag = !flag;
            }
            else {
                temp = stack2.peek();
                if(flag == true){
                    stack1.push(temp.left);
                    stack1.push(temp.right);
                }
                else {
                    stack1.push(temp.right);
                    stack1.push(temp.left);
                }
                subList.add(temp.data);
                list.add(subList);
                flag = !flag;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        //levelOrderTraversal(root, 0);
        List<List<Integer>> list = zigzagLevelOrder(root);
        System.out.println(Arrays.asList(list));
    }
}
