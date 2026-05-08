class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        if(arr[0]>arr[1])return 0;
        if(arr[n-1]>arr[n-2])return n-1;

        int l=0, r=arr.length-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid<arr.length-1 && arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return mid;
            }else if(mid>0 && arr[mid]<=arr[mid-1]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return n;
    }
}