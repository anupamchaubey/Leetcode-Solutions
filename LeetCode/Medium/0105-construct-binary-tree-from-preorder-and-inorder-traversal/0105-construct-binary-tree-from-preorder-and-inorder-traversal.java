class Solution {
    int preorderIndex;
    HashMap<Integer, Integer> hm=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex=0;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        return rec(preorder, 0, inorder.length-1);
    }
    TreeNode rec(int[] preorder, int l, int r){
        if(l>r)return null;
        int rootVal=preorder[preorderIndex++];
        TreeNode root=new TreeNode(rootVal);
        int idx=hm.get(rootVal);
        root.left=rec(preorder, l, idx-1);
        root.right=rec(preorder, idx+1, r);
        return root;
    }
}