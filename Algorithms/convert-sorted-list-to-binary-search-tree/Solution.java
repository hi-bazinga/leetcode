
public class Solution {
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        
        if (head.next == null) 
            return new TreeNode(head.val);
        
        ListNode listNode = findMidNode(head);
        TreeNode root = new TreeNode(listNode.val);
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(listNode.next);
        return root;
    }
    
    private ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode preSlow = head;
        ListNode slow = head;
        ListNode fast = head;
        
        // Even case, e.g. take '2' of '12' as middle 
        // in order to break the link between '1' and '2'
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // break tail link
        preSlow.next = null;
        return slow;
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
