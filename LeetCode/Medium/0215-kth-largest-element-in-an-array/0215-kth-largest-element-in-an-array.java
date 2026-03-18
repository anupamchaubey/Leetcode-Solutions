class Solution {
    class TreeNode{
        int val;
        int count;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.count=1;
        }
    }
    int ans;
    int count;
    public int findKthLargest(int[] nums, int k) {
        ans=-1;
        count=0;
        TreeNode root=new TreeNode(nums[0]);

        for(int i=1;i<nums.length;i++){
            insert(root, nums[i]);
        }
        reverseinorder(root, k);
        return ans;

    }
    void reverseinorder(TreeNode root, int k){
        if(root == null || ans != -1) return;
        reverseinorder(root.right, k);
        if(ans != -1) return;
        count+=root.count;
        if(count>=k){
            ans=root.val;
            return;
        }
        reverseinorder(root.left, k);
        
    }
    void insert(TreeNode root, int val){
        
        if(val==root.val){
            root.count++;
            return;
        }
        else if(val<root.val){
            if(root.left==null){
                root.left=new TreeNode(val);
                return;
            }
            insert(root.left, val);
        }else{
            if(root.right==null){
                root.right=new TreeNode(val);
                return;
            }
            insert(root.right, val);
        }
    }
}