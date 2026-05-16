class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int l=0, r=n-1;
        int ans=arr[0];
        
        while(l<r){
            int mid=l+(r-l)/2;

            if(arr[mid]>arr[r]){
                l=mid+1;
            }else if(arr[mid]<arr[l]){
                r=mid;
            }else{
                r--;
            }
        }
        return arr[l];
    }
}