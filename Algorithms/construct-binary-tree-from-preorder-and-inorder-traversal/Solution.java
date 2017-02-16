public class Solution {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildNode(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        if (inStart == inEnd)
            return new TreeNode(inorder[inStart]);

        // root node
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // find inorder position of root node
        int inIndex = inStart;
        for (; inIndex < inEnd; inIndex++) {
            if (preorder[preStart] == inorder[inIndex])
                break;
        }
        
        int leftNodeNum = inIndex - inStart;
        root.left = buildNode(preorder, inorder, preStart + 1, preStart + leftNodeNum, inStart, inIndex - 1);
        root.right = buildNode(preorder, inorder, preStart + leftNodeNum + 1, preEnd, inIndex + 1, inEnd);
        
        return root;
    }
    
    // For test
    public static void main(String[] args){
        int[] preorder = {2, 6, 9, 4, 8, 1, 3};
        int[] inorder = {6, 4, 9, 2, 1, 8, 3};
        
        TreeNode root = new Solution().buildTree(preorder, inorder);
        System.out.println(root.val);
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

