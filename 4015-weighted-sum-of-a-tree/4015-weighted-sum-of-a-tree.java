class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int[] depth = new int[nums.length];

        int h = 0;
        for (int i = 0; i < nums.length; i++)
            h = Math.max(h, rec(parent, i, depth));

        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i] * (h - depth[i] + 1);
        }
        return sum;
    }

    int rec(int[] parent, int idx, int[] depth) {
        
        if(depth[idx]!=0)return depth[idx];

        if (parent[idx] == -1) {
            depth[idx] = 1;
            return 1;
        }

        depth[idx] = rec(parent, parent[idx], depth) + 1;

        return depth[idx];
    }
}