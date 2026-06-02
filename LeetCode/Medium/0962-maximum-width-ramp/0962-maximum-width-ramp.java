class Solution {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (st.isEmpty() || nums[i] < nums[st.peek()]) {
                st.push(i);
            }
        }
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                int idx = st.pop();
                max = Math.max(max, i - idx);
            }
        }
        return max;
    }
}