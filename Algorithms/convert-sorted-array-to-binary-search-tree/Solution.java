
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(nums[start]);
        
        int rootIndex = (end + start) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        
        root.left = buildTree(nums, start, rootIndex - 1);
        root.right = buildTree(nums, rootIndex + 1, end);
        return root;
    }
    
    // For test
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        TreeNode root = new Solution().sortedArrayToBST(nums);
        System.out.println(root.val);
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}