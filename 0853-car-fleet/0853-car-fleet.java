class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(b[0], a[0]);
        });
        Stack<Double> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            double x = (target - arr[i][0]) / (double) arr[i][1];
            if (!st.isEmpty() && x <= st.peek()) {
                continue;
            } else
                st.push(x);
        }
        return st.size();
    }
}