class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    nums[j] += 1;
                } else {
                    nums[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, histogram(nums));
        }
        return maxArea;
    }

    int histogram(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();
            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();
            if (st.isEmpty()) {
                right[i] = nums.length;
            } else {
                right[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int mul = (i - left[i]) + (right[i] - i) - 1;
            max = Math.max(max, mul * nums[i]);
        }
        return max;
    }
}