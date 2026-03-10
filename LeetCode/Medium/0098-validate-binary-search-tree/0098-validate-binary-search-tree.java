class Solution {
    // RANGE METHOD 
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    boolean validate(TreeNode root, long min, long max){
        if(root==null)return true;
        if(root.val<= min || root.val>=max)return false;
        return validate(root.left, min, root.val)&& validate(root.right, root.val, max);
    }

    // List<Integer> ls= new ArrayList<>();
    // public boolean isValidBST(TreeNode root){
    //     inorder(root);
    //     for(int i=0;i<ls.size()-1;i++){
    //         if(ls.get(i)>=ls.get(i+1))return false;
    //     }
    //     return true;
    // }

    // void inorder(TreeNode root){
    //     if(root==null)return;
    //     inorder(root.left);
    //     ls.add(root.val);
    //     inorder(root.right);
    // }

}