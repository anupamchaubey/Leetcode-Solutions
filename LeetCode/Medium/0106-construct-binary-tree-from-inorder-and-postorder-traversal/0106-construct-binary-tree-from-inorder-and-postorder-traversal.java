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
    HashMap<Integer, Integer> hm;// for finding index in inorder
    int postIndex; // for postorder index
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hm= new HashMap<>();
        postIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length-1);

    }
    TreeNode build(int[] postorder, int l, int r){
        if(l>r)return null;

        TreeNode root=new TreeNode(postorder[postIndex--]);
        int index=hm.get(root.val);
        
        
        root.right=build(postorder, index+1, r);
        root.left=build(postorder, l, index-1);

        return root;

    }

}