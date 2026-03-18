class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        int max = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        for (int i:hs) {
            if (!hs.contains(i - 1)) {
                int j = i;
                count = 0;
                while (hs.contains(j)) {
                    count++;
                    j++;
                }
            }

            max = Math.max(count, max);
        }
        return max;

    }
}