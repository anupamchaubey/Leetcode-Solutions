class Solution {
    public int[] asteroidCollision(int[] rocks) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] > 0) {
                st.push(i);
                continue;
            } else {
                while (!st.isEmpty() && rocks[st.peek()] > 0 && Math.abs(rocks[i]) > rocks[st.peek()]) {
                    st.pop();
                }
                if (!st.isEmpty() && rocks[st.peek()] > 0 && Math.abs(rocks[i]) == rocks[st.peek()]) {
                    st.pop();
                    continue;
                }
                if (st.isEmpty() || rocks[st.peek()] < 0) {
                    st.push(i);
                }
            }
        }
        int[] arr = new int[st.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = rocks[st.pop()];
        }
        return arr;
    }
}