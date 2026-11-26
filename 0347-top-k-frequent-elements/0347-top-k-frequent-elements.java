class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : nums) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int key : hm.keySet()) {
            int freq = hm.get(key);
            buckets[freq].add(key);
        }

        int[] arr = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int x : buckets[i]) {
                if (idx == arr.length)
                    return arr;
                arr[idx++] = x;
            }
        }
        return arr;
    }
}