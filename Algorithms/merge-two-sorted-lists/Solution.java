/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode headNode;
        if (l1.val > l2.val) {
            headNode = l2;
            l2 = l2.next;
        } else {
            headNode = l1;
            l1 = l1.next;
        }
        
        ListNode curNode = headNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curNode.next = l2;
                l2 = l2.next;
            } else {
                curNode.next = l1;
                l1 = l1.next;
            }
            curNode = curNode.next;
        }

        curNode.next = l1 != null ? l1 : l2;
        
        return headNode;
    }
}