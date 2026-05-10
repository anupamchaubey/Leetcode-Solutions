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
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a, b)-> a.val-b.val);

        for(ListNode node: lists){
            if(node==null)continue;
            pq.offer(node);
        }

        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;

        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            temp.next=node;
            
            if(node.next!=null){
                pq.offer(node.next);
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}