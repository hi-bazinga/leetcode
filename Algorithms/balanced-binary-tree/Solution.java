
public class Solution {
    
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        boolean isRootBalanced = Math.abs(calHeight(root.left) - calHeight(root.right)) < 2;
        return isRootBalanced && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int calHeight(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(calHeight(root.left), calHeight(root.right));
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
        System.out.println(new Solution().isBalanced(n3));
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}