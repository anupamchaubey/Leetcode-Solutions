class Solution {

    int[] tree;

    void update(int node, int start, int end, int val) {
        if (start == end) {
            tree[node]++;
            return;
        }
        int mid = (start + end) / 2;
        if (val <= mid) {
            update(2 * node + 1, start, mid, val);
        } else {
            update(2 * node + 2, mid + 1, end, val);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    int query(int node, int start, int end, int l, int r) {
        if (end < l || start > r)
            return 0;
        if (start >= l && end <= r)
            return tree[node];

        int mid = (start + end) / 2;
        int left = query(2 * node + 1, start, mid, l, r);
        int right = query(2 * node + 2, mid + 1, end, l, r);
        return left + right;
    }

    public int createSortedArray(int[] instructions) {
        int MOD = (int) 1e9 + 7;
        int size = 100001;

        int n = instructions.length;

        tree = new int[4 * size];

        long sum = 0;

        for (int i = 0; i < instructions.length; i++) {
            sum += Math.min(
                    query(0, 0, size - 1, 0, instructions[i] - 1),
                    query(0, 0, size - 1, instructions[i] + 1, size - 1));
            sum %= MOD;
            update(0, 0, size - 1, instructions[i]);

        }
        return (int) sum;
    }
}