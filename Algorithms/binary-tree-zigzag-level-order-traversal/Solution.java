
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import binary_tree_level_order_traversal.TreeNode;

public class Solution {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null)
            return resultList;
        
        List<TreeNode> curLevelNodes = new ArrayList<TreeNode>();
        curLevelNodes.add(root);
        
        int level = 1;
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
            
            if (level % 2 == 0)
                Collections.reverse(curLevelNums);
            resultList.add(curLevelNums);
            
            curLevelNodes = nextLevelNodes;
            level ++;
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