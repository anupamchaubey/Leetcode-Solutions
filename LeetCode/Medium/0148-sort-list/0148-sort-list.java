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
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        ListNode temp=head;
        while(temp!=null){
            pq.offer(temp.val);
            temp=temp.next;
        }
        if(pq.isEmpty())return null;
        ListNode node=new ListNode (pq.poll());
        head=node;
        while(!pq.isEmpty()){
            node.next=new ListNode(pq.poll());
            node=node.next;
        }
        return head;
    }
}