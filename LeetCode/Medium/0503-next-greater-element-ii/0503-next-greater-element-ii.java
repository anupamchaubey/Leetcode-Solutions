class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i%n])st.pop();
            if(i<n){
                ans[i]=(st.isEmpty())? -1: nums[st.peek()];
            }
            st.push(i%n);
        }
        return ans;
    }
}