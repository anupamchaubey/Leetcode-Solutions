class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] r = new int[heights.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                r[i] = heights.length;
            } else
                r[i] = st.peek();
            st.push(i);
        }
        st = new ArrayDeque<>();
        int[] l = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                l[i] = -1;
            } else
                l[i] = st.peek();
            st.push(i);
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = (i - l[i] - 1);
            width += (r[i] - i);
            max = Math.max(max, heights[i] * width);
        }
        return max;
    }
}