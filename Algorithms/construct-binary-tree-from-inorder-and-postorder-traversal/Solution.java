public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildNode(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode buildNode(int[] inorder, int[] postorder, int inStart, int inEnd, int poStart, int poEnd) {
        if (inStart > inEnd)
            return null;
        if (inStart == inEnd)
            return new TreeNode(inorder[inStart]);
        
        // root node
        int rootValue = postorder[poEnd];
        TreeNode root = new TreeNode(rootValue);
        
        // find inorder position of root node
        int inIndex = inStart;
        for (; inIndex < inEnd; inIndex++) {
            if (inorder[inIndex] == rootValue)
                break;
        }
        
        int leftNodeNum = inIndex - inStart;
        root.left = buildNode(inorder, postorder, inStart, inIndex - 1, poStart, poStart + leftNodeNum - 1);
        root.right = buildNode(inorder, postorder, inIndex + 1, inEnd, poStart + leftNodeNum, poEnd - 1);
        
        return root;
    }
    
    // For test
    public static void main(String[] args) {
        int[] inorder = {6, 4, 9, 2, 1, 8, 3};
        int[] postorder = {4, 9, 6, 1, 3, 8, 2};
    
        TreeNode root = new Solution().buildTree(inorder, postorder);
        System.out.println(root.val);
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
