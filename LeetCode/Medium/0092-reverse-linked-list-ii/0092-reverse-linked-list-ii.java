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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp=head;
        int cl=1;
        ArrayList<Integer> hs= new ArrayList<> ();
        while(temp!=null && cl<left){
            cl+=1;
            temp=temp.next;
        }
        ListNode lf=temp;
        while(temp!=null && cl<=right){
            hs.add(temp.val);
            cl+=1;
            temp=temp.next;
        }
        
        Collections.reverse(hs);
        int u=0;
        while(u<hs.size()){
            lf.val=hs.get(u);
            u++;
            lf=lf.next;
        }
        
        
        
        
        
        return head;

    }

}