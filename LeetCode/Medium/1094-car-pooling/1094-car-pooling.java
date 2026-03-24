class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //Perform multiple range updates efficiently
        //Difference Array Pattern
        int[] arr= new int[1001];
        for(int[] t: trips){
            int val=t[0];
            int l=t[1];
            int r=t[2];
            arr[l]+=val;
            arr[r]-=val;
        }
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
        }
        for(int x: arr)if(x>capacity)return false;
        return true;
    }
}