class Solution {
    public boolean canAliceWin(int n) {
        
        int k=10;
        while(n>=0){
            n=n-k;
            
            if(n<0){
                return false;
            }
            k--;
            n=n-k;
            if(n<0){
                return true;
            }
            k--;
        }
        return true;
    }
}