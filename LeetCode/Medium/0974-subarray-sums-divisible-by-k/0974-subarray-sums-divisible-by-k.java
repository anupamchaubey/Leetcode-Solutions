class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int val = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            val += nums[i];
            int mod =val % k;
            if (mod < 0)
                mod += k;
            if (hm.containsKey(mod)) {
                count += hm.getOrDefault(mod, 0);
            }
            hm.put(mod, hm.getOrDefault(mod, 0) + 1);
        }
        return count;
    }
}