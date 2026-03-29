class Solution {
    public int maxEnvelopes(int[][] env) {
        int n=env.length;
        Arrays.sort(env, (a, b)-> {
            if(a[0]==b[0]){
                return b[1]-a[1];
            }return a[0]-b[0];
        });

        int max=0;
        int size=0;
        int[] tails=new int[n];
        for(int i=0;i<n;i++){
            int l=0,r=size;
            while(l<r){
                int mid=l+(r-l)/2;
                if(tails[mid]<env[i][1]){
                    l=mid+1;
                }else{
                    r=mid;
                }
            }
            tails[l]=env[i][1];
            if(l==size)size++;
        }
        return size;
    }
}