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
        if (head == null || k == 1)
            return head;
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null)
                return head;
            temp = temp.next;
        }

        ListNode prev = reverse(head, null, temp);
        head.next = reverseKGroup(temp, k);
        return prev;
    }

    ListNode reverse(ListNode curr, ListNode prev, ListNode stop) {
        if (curr == stop)
            return prev;
        ListNode next = curr.next;

        curr.next = prev;
        return reverse(next, curr, stop);
    }
}