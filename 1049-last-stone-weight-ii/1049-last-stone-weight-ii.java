class Solution {
    public int lastStoneWeightII(int[] stones) {
        HashMap<String, Integer> hm = new HashMap<>();

        int ans=back(stones, 0, 0, hm);
        return ans;

    }

    int back(int[] stones, int i, int sum, HashMap<String, Integer> hm) {
        if (i == stones.length)
            return Math.abs(sum);
        String key = i + "." + sum;
        if (hm.containsKey(key))
            return hm.get(key);
        int a = back(stones, i + 1, sum + stones[i], hm);
        int b = back(stones, i + 1, sum - stones[i], hm);
        int x = Math.min(a, b);
        hm.put(key, x);
        return x;

    }
}