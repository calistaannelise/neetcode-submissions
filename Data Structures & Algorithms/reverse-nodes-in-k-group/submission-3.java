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
        ListNode first = head, second = head, tmp = head, prev = head,newHead=head;
        while (tmp != null) {
            for (int i = 0; i < k-1; i++) {
                if (tmp == null) {
                    break;
                }
                tmp = tmp.next;
            }
            if (tmp != null) {
                ListNode next1 = tmp.next;
                tmp.next = null;
                second = ReverseNode(first, tmp);
                if (first == head) {
                    prev = first;
                    newHead=second;
                } else {
                    prev.next = second;
                    prev = first;
                }
                tmp = next1;
                first = tmp;
            } else {
                prev.next = first;
            }
        }
        return newHead;
    }
    public ListNode ReverseNode(ListNode first, ListNode last) {
        ListNode tmp, prev=null;
        tmp = first;
        while (tmp != null) {
            ListNode curr = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = curr;
        }
        return prev;
    }
}
