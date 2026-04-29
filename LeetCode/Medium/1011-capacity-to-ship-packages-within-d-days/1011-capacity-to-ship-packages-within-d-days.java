class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0, r=0;

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
        int count=1;
        
        int c=0;
        int i=0;
        while(i<weights.length){
            if(c+weights[i]>cap){
                count++;
                c=weights[i];
            }else{
                c+=weights[i];
            }
            
            i++;
        }
        return count<=days;
    }
}