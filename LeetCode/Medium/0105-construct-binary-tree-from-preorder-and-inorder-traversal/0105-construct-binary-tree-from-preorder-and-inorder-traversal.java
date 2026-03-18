/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preidx;
    HashMap<Integer, Integer> hm;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preidx=0;
        hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        return rec(preorder, 0, inorder.length-1);
    }
    TreeNode rec(int[] preorder, int l, int r){
        if(l>r)return null;
        int val=preorder[preidx++];
        TreeNode root=new TreeNode(val);
        root.left=rec(preorder, l, hm.get(val)-1);
        root.right=rec(preorder, hm.get(val)+1, r);
        return root;
    }
}