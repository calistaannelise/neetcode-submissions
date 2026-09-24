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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode ret = new ListNode(0);
        ListNode curr = ret;
        int remainder = 0;

        while (p1 != null && p2 != null) {
            int res = p1.val + p2.val + remainder;
            remainder = res / 10;
            curr.next = new ListNode(res % 10);
            curr = curr.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            int res = p1.val + remainder;
            remainder = res / 10;
            curr.next = new ListNode(res % 10);
            curr = curr.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            int res = p2.val + remainder;
            remainder = res / 10;
            curr.next = new ListNode(res % 10);
            curr = curr.next;
            p2 = p2.next;
        }
        if (remainder > 0) {
            curr.next = new ListNode(remainder);
        }
        return ret.next;
    }
}
