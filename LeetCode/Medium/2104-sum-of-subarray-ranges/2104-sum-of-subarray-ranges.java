class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();
            if (st.isEmpty())
                leftMin[i] = -1;
            else
                leftMin[i] = st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i])
                st.pop();
            if (st.isEmpty()) {
                rightMin[i] = n;
            } else
                rightMin[i] = st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                st.pop();
            if (st.isEmpty())
                leftMax[i] = -1;
            else
                leftMax[i] = st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i])
                st.pop();
            if (st.isEmpty())
                rightMax[i] = n;
            else
                rightMax[i] = st.peek();
            st.push(i);
        }

        st.clear();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long max1 = (long) (i - leftMax[i]) * (rightMax[i] - i);
            long max2 = (long) (i - leftMin[i]) * (rightMin[i] - i);
            sum += (max1 - max2) * nums[i];
        }
        return sum;
    }
}