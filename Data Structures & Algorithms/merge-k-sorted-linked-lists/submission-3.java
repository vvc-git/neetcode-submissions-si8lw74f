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

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        ListNode head = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            res.next = new ListNode(l1.val);
            res = res.next;
            l1 = l1.next;
        } 

        while (l2 != null) {
            res.next = new ListNode(l2.val);
            res = res.next;
            l2 = l2.next;
        }
        return head.next;
    }       


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode prev = mergeTwoList(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            prev = mergeTwoList(prev, lists[i]);
        }
        return prev;
    }
}
