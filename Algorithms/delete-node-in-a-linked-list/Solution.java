
public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null)
            return;
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}