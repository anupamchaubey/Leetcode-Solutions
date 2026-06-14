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
    public int pairSum(ListNode head) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        ListNode temp=head;
        int idx=0;
        while(temp!=null){
            hm.put(idx, temp.val);
            temp=temp.next;
            idx++;
        }
        int half=(idx+1)/2;
        int a=half-1;
        int b=half;
        int max=-1;
        while(a>=0){
            int sum=hm.get(a)+hm.get(b);
            max=Math.max(max, sum);
            a--;
            b++;
        }
        return max;
    }
}