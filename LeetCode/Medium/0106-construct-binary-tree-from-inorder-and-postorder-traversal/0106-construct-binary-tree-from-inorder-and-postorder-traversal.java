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
    HashMap<Integer, Integer> hm;
    int postidx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hm=new HashMap<>();
        postidx=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        return rec(postorder, 0, inorder.length-1);
    }
    TreeNode rec(int[] postorder, int l, int r){
        if(l>r)return null;
        int rootVal=postorder[postidx--];
        TreeNode root=new TreeNode(rootVal);
        int idx=hm.get(rootVal);
        root.right=rec(postorder, idx+1, r);
        root.left=rec(postorder, l, idx-1);
        return root;
    }
}