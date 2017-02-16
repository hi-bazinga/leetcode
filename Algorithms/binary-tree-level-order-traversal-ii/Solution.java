
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null) 
            return resultList;

        // First level
        List<TreeNode> curLevelNodes = new ArrayList<TreeNode>();
        curLevelNodes.add(root);
        
        // Loop: traverse each level
        while (!curLevelNodes.isEmpty()) {
            List<TreeNode> nextLevelNodes = new ArrayList<TreeNode>();
            List<Integer> curLevelVals = new ArrayList<Integer>();
            
            for (TreeNode node : curLevelNodes) {
                curLevelVals.add(node.val);
                if (node.left != null)
                    nextLevelNodes.add(node.left);
                if (node.right != null)
                    nextLevelNodes.add(node.right);
            }
            
            resultList.add(curLevelVals);
            curLevelNodes = nextLevelNodes;
        }
        
        // Reverse result list
        Collections.reverse(resultList);
        
        return resultList;
    }
    
    // For test
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        
        n3.left = n1;
        n3.right = n2;
        n2.left = n4;
        n2.right = n5;
        
        List<List<Integer>> resultList = new Solution().levelOrderBottom(n3);
        for (List<Integer> list : resultList) {
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}