
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;
        
        if ((min == null || node.val > min) && (max == null || node.val < max))
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        else
            return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}