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

        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoList(lists[i-1], lists[i]);
        }
        return lists[lists.length - 1];
    }
}
