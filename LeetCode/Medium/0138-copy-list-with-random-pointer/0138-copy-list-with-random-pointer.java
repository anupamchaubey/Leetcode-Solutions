/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Integer, Node> hm1 = new HashMap<>();
        HashMap<Node, Integer> hm2 = new HashMap<>();

        Node temp = head;
        int idx = 0;
        while (temp != null) {
            hm1.put(idx, temp);
            hm2.put(temp, idx);
            idx++;
            temp = temp.next;
        }
        HashMap<Integer, Node> hm3 = new HashMap<>();
        Node dummy = new Node(0);
        temp = dummy;
        for (int i = 0; i < hm1.size(); i++) {
            temp.next = new Node(hm1.get(i).val);
            temp = temp.next;
            hm3.put(i, temp);
        }

        for (int i = 0; i < hm1.size(); i++) {
            Node node = hm1.get(i);
            if (node.random != null) {
                idx = hm2.get(node.random);
                hm3.get(i).random = hm3.get(idx);
            }
        }
        return dummy.next;

    }
}