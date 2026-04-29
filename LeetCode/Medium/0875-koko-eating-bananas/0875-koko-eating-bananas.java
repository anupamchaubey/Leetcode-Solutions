class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r=-1;
        for(int x: piles){
            r=Math.max(x, r);
        }
        int l=1;
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
    boolean isValid(int[] piles, int speed, int h){
        int time=0;
        for(int i=0;i<piles.length;i++){
            time+=(piles[i]+speed-1)/speed;
        }
        return time<=h;
    }

}