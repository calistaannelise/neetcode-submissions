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
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        int l = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            l++;
        }
        ListNode ret = head;
        ListNode hi = head;
        ListNode lo = null;

        if (l % 2 == 1) {
            hi = head.next;
        }

        int half = l / 2;
        for (int i = 0; i < half; i++) {
            lo = hi;
            hi = hi.next;
        }
        lo.next = null;
        // reverse hi
        ListNode prev = null;
        ListNode curr = hi;
        while (curr != null) {
            hi = hi.next;
            curr.next = prev;
            prev = curr;
            curr = hi;
        }

        // merge
        // prev = reversed
        // ret = start of original
        lo = ret.next;
        curr = ret;
        while (prev != null && lo != null) {
            curr.next = prev;
            curr = curr.next;
            prev = prev.next;
            curr.next = lo;
            lo = lo.next;
            curr = curr.next;
        }
        if (prev != null) {
            curr.next = prev;
        }
    }
}
