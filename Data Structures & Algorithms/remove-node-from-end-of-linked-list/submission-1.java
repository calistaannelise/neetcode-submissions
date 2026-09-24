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
        if (head.next == null) {
            return null;
        }
        int l = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            l++;
        }

        int idx = l - n;
        if (idx == 0) {
            return head.next;
        }

        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < idx; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;
    }
}
