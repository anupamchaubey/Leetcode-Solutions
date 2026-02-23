class Solution {
    int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
    }
    int height(TreeNode root){
        if(root==null)return 0;
        int l=height(root.left);
        int r=height(root.right);
        int ans=Math.max(l, r)+1;
        dia=Math.max(dia, l+r);
        return ans;
    }
}