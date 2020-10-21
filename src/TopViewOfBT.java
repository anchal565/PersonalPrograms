import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Using DFS
public class TopViewOfBT {

    TreeMap<Integer, List<Integer>> treeMap;
    public TopViewOfBT(){
        treeMap = new TreeMap<>();
    }

    public void topView(TreeNode root){
        topViewHelperUsingDFS(root, 0, 0);
        for(Map.Entry<Integer, List<Integer>> map : treeMap.entrySet()){
            System.out.print(map.getValue().get(1)+" ");
        }
        System.out.println();
    }

    public  void topViewHelperUsingDFS(TreeNode root, int level, int distance){
        if(root == null)
            return;
        if(treeMap.get(distance) != null) {
            List<Integer> subList = treeMap.get(distance);
            if(subList.get(0) > level) {
                subList.set(0, level);
                subList.set(1, root.data);
                treeMap.put(distance, subList);
            }
        }
        else {
            List<Integer> subList = new ArrayList<>();
            subList.add(0, level);
            subList.add(1, root.data);
            treeMap.put(distance, subList);
        }
        topViewHelperUsingDFS(root.left, level+1, distance-1);
        topViewHelperUsingDFS(root.right, level+1, distance+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        TopViewOfBT topViewOfBT = new TopViewOfBT();
        topViewOfBT.topView(root);
        //System.out.println(width);
    }
}
