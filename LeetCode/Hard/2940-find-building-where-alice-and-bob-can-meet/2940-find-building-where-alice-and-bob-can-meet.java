class Solution {
    int[] tree;

    void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        build(nums, 2 * node + 1, start, mid);
        build(nums, 2 * node + 2, mid + 1, end);
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    int query(int node, int start, int end, int l, int r) {
        if (end < l || tree[node] <= r)
            return -1;
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        int left = query(2 * node + 1, start, mid, l, r);
        if (left != -1)
            return left;
        int right = query(2 * node + 2, mid + 1, end, l, r);
        return right;
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        tree = new int[4 * n];

        build(heights, 0, 0, n - 1);
        int[] ans = new int[queries.length];

        for (int i = 0; i < ans.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }

            if (a == b || heights[b] > heights[a]) {
                ans[i] = b;
            } else {
                ans[i] = query(0, 0, n - 1, b + 1, heights[a]);
            }
        }
        return ans;
    }
}