class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // we will use the bucket sort
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : nums) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : hm.keySet()) {
            if (bucket[hm.get(key)] == null)
                bucket[hm.get(key)] = new ArrayList<>();
            bucket[hm.get(key)].add(key);
        }

        int l = nums.length;

        int i = 0;
        int[] ans = new int[k];
        while (i < k) {
            while (bucket[l] == null || bucket[l].size() == 0) {
                l--;
            }
            ans[i] = bucket[l].get(0);
            bucket[l].remove(0);
            i++;
        }
        return ans;
    }
}