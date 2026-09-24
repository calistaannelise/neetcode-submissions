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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = null;
        int idx = 0;
        while (idx < lists.length) {
            if (lists[idx] != null) {
                head = lists[idx];
                break;
            }
            idx++;
        }

        for (int i = idx + 1; i < lists.length; i++) {
            ListNode list1 = head;
            ListNode list2 = lists[i];

            if (list2 == null) {
                continue;
            }
            
            if (list1.val > list2.val) {
                head = list2;
                list2 = list2.next;
            } else {
                head = list1;
                list1 = list1.next;
            }
            
            ListNode curr = head;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }
            if (list1 != null) {
                curr.next = list1;
            }
            if (list2 != null) {
                curr.next = list2;
            }
        }
        return head;
    }
}
