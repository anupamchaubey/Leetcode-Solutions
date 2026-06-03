class Solution {
    public int maxWidthRamp(int[] nums) {
        int max=0;
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(st.isEmpty() || nums[i]<nums[st.peek()])st.push(i);
        }
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
                max=Math.max(max, i-st.peek());
                st.pop();
            }
        }
        return max;
    }
}