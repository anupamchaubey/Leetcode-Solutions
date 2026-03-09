class Solution {
    int postorderIndex;
    HashMap<Integer, Integer> hm= new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        return rec(postorder, 0, postorder.length-1);
    }
    TreeNode rec(int[] postorder, int l, int r){
        if(l>r)return null;
        int rootVal=postorder[postorderIndex--];
        TreeNode root=new TreeNode(rootVal);

        int idx=hm.get(rootVal);
        //why right first?
        root.right=rec(postorder, idx+1, r);
        root.left=rec(postorder, l, idx-1);

        return root;
    }

}