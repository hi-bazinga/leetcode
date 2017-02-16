
import java.util.ArrayList;
import java.util.List;

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null)
            return sb.toString();
        
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        List<TreeNode> tmpNodeList = null;
        StringBuilder tmpSb = null;
        sb.append(root.val).append(",");
        nodeList.add(root);
        
        while (!nodeList.isEmpty()) {
            tmpNodeList = new ArrayList<TreeNode>();
            tmpSb = new StringBuilder();
            for (TreeNode node : nodeList) {
                if (node.left != null) {
                    tmpSb.append(node.left.val).append(",");
                    tmpNodeList.add(node.left);
                } else {
                    tmpSb.append("null").append(",");
                }
                if (node.right != null) {
                    tmpSb.append(node.right.val).append(",");
                    tmpNodeList.add(node.right);
                } else {
                    tmpSb.append("null").append(",");
                }
            }
            if (tmpNodeList.size() > 0)
                sb.append(tmpSb);
            nodeList = tmpNodeList;
        }
        
        return sb.substring(0, sb.length() - 1).trim();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        
        String[] valArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(valArr[0]));
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        List<TreeNode> nextLevelNodes = null;
        nodeList.add(root);
        
        int index = 1;
        while (index < valArr.length) {
            nextLevelNodes = new ArrayList<TreeNode>();
            for (int j = 0; j < nodeList.size(); j++) {
                TreeNode curNode = nodeList.get(j);
                String val = valArr[index];
                if (!"null".equals(val)) {
                    curNode.left = new TreeNode(Integer.parseInt(val));
                    nextLevelNodes.add(curNode.left);
                }
                if (index + 1 < valArr.length && !"null".equals(valArr[index + 1])) {
                    curNode.right = new TreeNode(Integer.parseInt(valArr[index + 1]));
                    nextLevelNodes.add(curNode.right);
                }
                index += 2;
            }
            nodeList = nextLevelNodes;
        }
        
        return root;
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
        
        String str = new Codec().serialize(n3);
        System.out.println(str);
        
        TreeNode node = new Codec().deserialize(str);
        System.out.println(node.val);
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}