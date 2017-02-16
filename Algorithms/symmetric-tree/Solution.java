
public class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if ((node1 == null && node2 != null) 
                || (node1 != null && node2 == null) 
                || (node1.val != node2.val))
            return false;

        return compare(node1.left, node2.right) && compare(node1.right, node2.left);
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}