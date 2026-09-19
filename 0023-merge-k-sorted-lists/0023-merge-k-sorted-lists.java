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
        // PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // for (int i = 0; i < lists.length; i++) {
        //     ListNode temp = lists[i];
        //     while (temp != null) {
        //         pq.offer(temp);
        //         temp = temp.next;
        //     }
        // }

        // ListNode node = new ListNode(0);
        // ListNode head = node;
        // while (!pq.isEmpty()) {
        //     node.next = pq.poll();
        //     node = node.next;
        // }
        // node.next = null;
        // return head.next;

        ListNode node = null;
        for (int i = 0; i < lists.length; i++) {
            node = merge(node, lists[i]);
        }
        return node;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}