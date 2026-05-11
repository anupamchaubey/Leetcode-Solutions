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
        if(head==null)return head;
        Node next=flatten(head.next);
        Node node=head;
        
        if(node.child!=null){
            Node child=flatten(node.child);
            node.next=child;
            child.prev=node;

            node.child=null;

            Node temp=node;
            while(temp.next!=null)temp=temp.next;

            temp.next=next;

            if(next!=null)next.prev=temp;
            
        }else{
            node.next=next;
            if(next!=null)
            next.prev=node;
        }
        return head;
    }

}