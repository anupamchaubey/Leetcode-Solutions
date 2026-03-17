class Solution {
    int[] tree;
    int offset=10000;

    void update(int node, int start, int end, int val){
        if(start==end){
            tree[node]++;
            return ;
        }else{
            int mid=(start+end)/2;
            if(val<=mid){
                update(2*node+1, start, mid, val);
            }else{
                update(2*node+2, mid+1, end, val);
            }
            tree[node]=tree[2*node+1]+tree[2*node+2];
        }
    }
    int query(int node, int start, int end, int l, int val){
        if(l>end || val<start)return 0;// invalid
        if(start>=l && end<=val)return tree[node]; // complete overlap
        int mid=(start+end)/2;
        int left=query(2*node+1, start, mid, l, val);
        int right=query(2*node+2, mid+1, end, l, val);
        return left+right;
    }
    public List<Integer> countSmaller(int[] nums) {
        int size=20001;
        tree=new int[4*size];
        int n=nums.length;
        List<Integer> ls= new ArrayList<>();
        
        for(int i=n-1;i>=0;i--){
            int val=nums[i]+offset;
            ls.add(query(0, 0, size-1, 0, val-1));
            update(0, 0, size-1, val);
        }
        Collections.reverse(ls);
        return ls;
    }
}