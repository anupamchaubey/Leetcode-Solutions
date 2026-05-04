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
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp=head;
        ListNode root=new ListNode(0);
        ListNode tempo=root;

        while(temp!=null){
            if(temp.val!=val){
                tempo.next=new ListNode(temp.val);
                tempo=tempo.next;
            }
            temp=temp.next;
        }

        return root.next;
    }
}