class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums)
            hs.add(x);

        int max = 0;

        for (int x : nums) {
            if (!hs.contains(x))
                continue;
            int len = 1;
            int l = x - 1;
            int r = x + 1;
            hs.remove(x);
            while (hs.contains(l)) {
                hs.remove(l--);
                len++;
            }
            while (hs.contains(r)) {
                hs.remove(r++);
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}