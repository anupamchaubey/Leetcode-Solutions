class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr= new int[n];
        for(int[] b: bookings){
            int l=b[0];
            int r=b[1];
            int val=b[2];
            arr[l-1]+=val;
            if(r<n){
                arr[r]-=val;
            }
        }
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        return arr;
    }
}