class Solution {
    public boolean check(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i + 1;
                break;
            }
        }
        if (k == -1)
            return true;
        int j=0;
    
        int[] arr= new int[nums.length];
        
        
        for(int p=k;p<nums.length;p++){
            arr[j++]=nums[p];
        }
        for(int p=0;p<k;p++){
            arr[j++]=nums[p];
        }
        for(int i=0;i<nums.length-1;i++){
            System.out.print(arr[i]+" ");
            if(arr[i]>arr[i+1])return false;
        }
        
        return true;
    }
}