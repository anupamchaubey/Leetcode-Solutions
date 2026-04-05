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
    HashMap<Integer, Integer> inorderIndex;
    int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex=postorder.length-1;
        inorderIndex=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderIndex.put(inorder[i], i);
        }
        return rec(inorder, postorder, 0, inorder.length-1);
    }
    TreeNode rec(int[] inorder, int[] postorder, int l, int r){
        if(l>r )return null;
        TreeNode root=new TreeNode(postorder[postorderIndex--]);
        root.right=rec(inorder, postorder, inorderIndex.get(root.val)+1, r);
        root.left=rec(inorder, postorder, l, inorderIndex.get(root.val)-1);
        
        return root;
    }
}