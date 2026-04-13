/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node node=root;
        Queue<Node> q= new LinkedList<>();

        q.offer(node);
        while(!q.isEmpty()){
            int size=q.size();
            Node prev=q.poll();
            if(prev.left!=null){
                q.offer(prev.left);
            }
            if(prev.right!=null){
                q.offer(prev.right);
            }
            for(int i=0;i<size-1;i++){
                Node curr=q.poll();
                prev.next=curr;
                prev=curr;
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
        }
        return root;
    }
}