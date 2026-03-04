class Solution {
    public int integerBreak(int n) {
        if(n==3)return 2;
        if(n==2)return 1;
        int ans=1;
        while(n>0){
            if(n==2 || n==4 ){
                ans*=n;
                break;
            }
            ans*=3;
            n-=3;
        }
        return ans;
    }
}