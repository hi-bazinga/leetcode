import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        List<TreeNode> tmpNodeList = null;
        nodeList.add(root);
        
        while (!nodeList.isEmpty()) {
            tmpNodeList = new ArrayList<TreeNode>();
            for (int i = 0; i < nodeList.size(); i++) {
                TreeNode node = nodeList.get(i);
                if (i == nodeList.size() - 1) 
                    list.add(node.val);
                if (node.left != null)
                    tmpNodeList.add(node.left);
                if (node.right != null)
                    tmpNodeList.add(node.right);
            }
            nodeList = tmpNodeList;
        }
        
        return list;
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}