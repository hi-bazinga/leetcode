
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftDepth = 0;
        TreeNode leftTmp = root;
        while (leftTmp != null) {
            leftTmp = leftTmp.left;
            leftDepth ++;
        }
        
        int rightDepth = 0;
        TreeNode rightTmp = root;
        while (rightTmp != null) {
            rightTmp = rightTmp.right;
            rightDepth ++;
        }
        
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}