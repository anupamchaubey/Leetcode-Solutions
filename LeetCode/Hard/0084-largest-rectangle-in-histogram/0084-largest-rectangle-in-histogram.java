class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        int[] l = new int[n];
        int[] r = new int[n];

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                l[i] = -1;
            } else {
                l[i] = st.peek();
            }
            st.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!st1.isEmpty() && heights[st1.peek()] >= heights[i]) {
                st1.pop();
            }
            if (st1.isEmpty()) {
                r[i] = n;
            } else {
                r[i] = st1.peek();
            }
            st1.push(i);
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, (r[i] - l[i] - 1) * heights[i]);
        }
        return max;
    }
}