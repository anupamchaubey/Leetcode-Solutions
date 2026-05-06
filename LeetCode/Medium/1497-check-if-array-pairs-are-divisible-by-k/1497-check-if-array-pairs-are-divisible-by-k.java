class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        if(n%2!=0)return false;

        int[] freq=new int[k];

        for(int i=0;i<n;i++){
            int div=((arr[i]%k)+k)%k;
            freq[div]++;
        }

        int pair=0;
        for(int i=0;i<n;i++){
            int rem=((arr[i]%k)+k)%k;
            int need=((k-rem)%k);
            if(freq[rem]!=0){
                pair++;
                freq[rem]--;
                freq[need]--;
            }
        }
        return pair==n/2;
    }
}