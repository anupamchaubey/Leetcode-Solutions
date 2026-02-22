class Solution {
    public int binaryGap(int n) {
        int diff=0;
        int curr=0;
        boolean pr=false;
        while(n>0){
            if((n&1)==1){
                if(pr)diff=Math.max(diff, curr);
                curr=1;
                pr=true;
            }else{
                curr++;
            }
            n=n>>1;
        }
        return diff;
    }
}