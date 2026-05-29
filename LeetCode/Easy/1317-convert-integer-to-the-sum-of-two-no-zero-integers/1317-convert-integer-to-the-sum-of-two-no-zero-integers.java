class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        for(int i=1;i<n;i++){
            int x=i;
            boolean flag=false;
            while(x>0){
                if(x%10==0){
                    flag=true;
                    break;
                }
                x=x/10;
            }
            if(flag)continue;
            x=n-i;
            while(x>0){
                if(x%10==0){
                    flag=true;
                    break;
                }
                x=x/10;
            }
            if(!flag){
                return new int[]{i, n-i};
            }
        }
        return new int[]{-1, -1};
    }
}