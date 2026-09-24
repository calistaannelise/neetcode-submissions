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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (start != null) {
            ListNode end = start;
            int tempK = k;
            while (tempK > 0) {
                if (end == null) {
                    curr.next = start;
                    return dummy.next;
                }
                end = end.next;
                tempK--;
            }

            // reverse
            curr.next = reverse(start, end);
            curr = start;
            start = end;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
