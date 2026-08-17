class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                arr[i] = 0;
            } else {
                arr[i] = Math.abs(i - st.peek());
            }
            st.push(i);
        }
        return arr;
    }
}