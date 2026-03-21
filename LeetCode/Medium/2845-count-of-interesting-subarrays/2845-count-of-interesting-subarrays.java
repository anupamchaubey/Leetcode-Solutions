class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        long count = 0;
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % modulo == k)
                cnt++;
            int key =cnt % modulo;
            int target= (key-k+modulo)%modulo;
            if (hm.containsKey(target)) {
                count += hm.get(target);
            }
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        return count;
    }
}