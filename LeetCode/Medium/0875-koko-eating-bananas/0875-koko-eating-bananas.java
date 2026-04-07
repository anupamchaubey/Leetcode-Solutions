class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=-1;
        int n=piles.length;
        for(int i=0;i<n;i++){
            r=Math.max(r, piles[i]);
        }
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isValid(piles, mid, h)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    boolean isValid(int[] piles, int k, int h){
        int time=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]<=k){
                time++;
            }else{
                if(piles[i]%k==0)time+=(piles[i]/k);
                else{
                    time+=((piles[i]+k)/k);
                }
            }
        }
        return time<=h;
    }
}