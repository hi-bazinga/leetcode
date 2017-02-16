
import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        
        result.addAll(postorderTraversal1(root.left));
        result.addAll(postorderTraversal1(root.right));
        result.add(root.val);
        return result;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}