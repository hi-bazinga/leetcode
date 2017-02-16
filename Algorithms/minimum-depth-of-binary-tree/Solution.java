
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.right == null)
            return 1 + minDepth(root.left);
        if (root.left == null && root.right != null)
            return 1 + minDepth(root.right);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
