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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }
    TreeNode build(int[] nums, int l, int r){
        if(l>r)return null; 
        int max=-1;
        for(int i=l;i<=r;i++){
            if(max==-1 || nums[i]>nums[max])max=i;
        }
        TreeNode root=new TreeNode(nums[max]);
        root.left=build(nums, l, max-1);
        root.right=build(nums, max+1, r);

        return root;
    }
}