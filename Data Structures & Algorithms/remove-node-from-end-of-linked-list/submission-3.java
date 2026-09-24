/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode hi = head;
        ListNode lo = dummy;
        for (int i = 0; i < n; i++) {
            hi = hi.next;
        }

        while (hi != null) {
            hi = hi.next;
            lo = lo.next;
        }
        lo.next = lo.next.next;
        return dummy.next;
    }
}
