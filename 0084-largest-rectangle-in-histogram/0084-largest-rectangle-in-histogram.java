class Solution {
    public int largestRectangleArea(int[] heights) {
        return histogram(heights);
    }
    int histogram(int[] nums){
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])st.pop();
            if(st.isEmpty()){
                left[i]=-1;
            }else{
                left[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])st.pop();
            if(st.isEmpty()){
                right[i]=nums.length;
            }else{
                right[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        int max=0;
        for(int i=0;i<nums.length;i++){
            int mul=(i-left[i])+(right[i]-i)-1;
            max=Math.max(max, mul*nums[i]);
        }
        return max;
    }
}