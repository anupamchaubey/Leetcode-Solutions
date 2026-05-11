/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        Node node=head;
        if(node==null)return node;
        Node next=flatten(node.next);

        if(node.child!=null){
            node.next=flatten(node.child);
            node.child=null;
            node.next.prev=node;
            Node temp=node;
            while(temp.next!=null)temp=temp.next;
            temp.next=next;
            if(next!=null)next.prev=temp;
        }else{
            node.next=next;
            if(next!=null)next.prev=node;
        }
        return head;
    }
}