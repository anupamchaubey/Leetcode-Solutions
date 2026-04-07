class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=1;
        int r=0;
        for(int i=0;i<weights.length;i++){
            r+=weights[i];
            l=Math.max(l, weights[i]);
        }
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isValid(weights, mid, days)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    boolean isValid(int[] weights, int cap, int days){
        int d=0;
        int c=0;
        for(int i=0;i<weights.length;i++){
            c+=weights[i];
            if(c>cap){
                d++;
                c=weights[i];
            }
        }
        if(c>0)d++;
        return d<=days;
    }
}