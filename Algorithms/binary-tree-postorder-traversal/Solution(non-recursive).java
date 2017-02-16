
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> resultList = new LinkedList<Integer>();
        if (root == null)
            return resultList;
        
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            resultList.add(node.val);
            
            if (node.left != null)
                nodeStack.push(node.left);
            if (node.right != null)
                nodeStack.push(node.right);
        }
        
        Collections.reverse(resultList);
        return resultList;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}