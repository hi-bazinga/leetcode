import java.util.Stack;

public class Solution {
    
    // Non-recursive solution
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
                node.right = node.left;
                node.left = null;
            }
            if (node.left == null && node.right == null) {
                node.right = stack.isEmpty() ? null : stack.peek();
                node.left = null;
            }
        }
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
        
        new Solution().flatten(n3);
        System.out.println("Completed");
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}