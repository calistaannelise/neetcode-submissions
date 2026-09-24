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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head.next;
        ListNode curr = head.next;
        head.next = null;
        while (curr != null) {
            curr = curr.next;
            temp.next = head;
            head = temp;
            temp = curr;
        }
        return head;
    }
}
