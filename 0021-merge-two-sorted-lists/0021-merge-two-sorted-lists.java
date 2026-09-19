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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // ListNode node = new ListNode(0);
        // ListNode temp = node;
        // while (list1 != null && list2 != null) {
        //     if (list1.val < list2.val) {
        //         temp.next = list1;
        //         temp = temp.next;
        //         list1 = list1.next;
        //     } else {
        //         temp.next = list2;
        //         temp = temp.next;
        //         list2 = list2.next;
        //     }
        // }
        // if (list1 != null)
        //     temp.next = list1;
        // if (list2 != null)
        //     temp.next = list2;
        // return node.next;
        return rec(list1, list2);
    }

    ListNode rec(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = rec(list1.next, list2);
            return list1;
        } else {
            list2.next = rec(list1, list2.next);
            return list2;
        }
    }
}