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
    int preIndex;
    int n;
    HashMap<Integer, Integer> inorderIndex; // value, index in inorder array
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n=preorder.length;
        preIndex=0;
        inorderIndex=new HashMap<>();
        for(int i=0;i<n;i++){
            inorderIndex.put(inorder[i], i);
        }
        return rec(preorder, inorder, 0, n-1);
    }
    TreeNode rec(int[] preorder, int[] inorder, int l, int r){
        if(l>r)return null;
        TreeNode root=new TreeNode(preorder[preIndex++]);
        root.left=rec(preorder, inorder, l, inorderIndex.get(root.val)-1);
        root.right=rec(preorder, inorder, inorderIndex.get(root.val)+1, r);
        return root;
    }
}