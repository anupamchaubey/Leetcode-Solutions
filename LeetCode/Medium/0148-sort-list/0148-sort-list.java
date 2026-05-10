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
        return divide(head);
    }
    ListNode divide(ListNode head){
        if(head==null || head.next==null)return head; 
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        ListNode l1=divide(head);
        ListNode l2=divide(mid);

        return merge(l1, l2);
    }
    ListNode merge(ListNode l1, ListNode l2){

        ListNode dum=new ListNode(0);
        ListNode dummy=dum;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                dummy.next=l1;
                l1=l1.next;
            }else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;
        }
        if(l1!=null){
            dummy.next=l1;
        }
        if(l2!=null){
            dummy.next=l2;
        }
        return dum.next;
    }
}