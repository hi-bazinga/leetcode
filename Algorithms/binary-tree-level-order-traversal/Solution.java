
import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null)
            return resultList;
        
        List<TreeNode> curLevelNodes = new ArrayList<TreeNode>();
        curLevelNodes.add(root);
        
        while (!curLevelNodes.isEmpty()) {
            List<TreeNode> nextLevelNodes = new ArrayList<TreeNode>();
            List<Integer> curLevelNums = new ArrayList<Integer>();
            
            for (TreeNode node : curLevelNodes) {
                curLevelNums.add(node.val);
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }
            resultList.add(curLevelNums);
            curLevelNodes = nextLevelNodes;
        }
        
        return resultList;
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}