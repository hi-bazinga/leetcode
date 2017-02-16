
public class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        while ((result.val - p.val) * (result.val - q.val) > 0) {
            result = result.val > p.val ? result.left : result.right;
        }
        return result;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}