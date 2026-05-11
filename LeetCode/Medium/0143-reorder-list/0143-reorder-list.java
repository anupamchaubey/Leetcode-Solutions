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
    public void reorderList(ListNode head) {
        //find mid
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;

        //reverse second half
        ListNode prev=null;
        ListNode curr=mid;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        // merge the two linkedlists alternatively

        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        while(head!=null && prev!=null){
            temp.next=head;
            head=head.next;
            temp=temp.next;
            temp.next=prev;
            prev=prev.next;
            temp=temp.next;
        }
        if(head!=null)temp.next=head;
        if(prev!=null)temp.next=prev;

        head=dummy.next;
    }
}