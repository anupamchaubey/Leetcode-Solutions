class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums)
            hs.add(x);
        int max = 0;
        for (int x : nums) {
            if (hs.contains(x - 1))
                continue;
            int c = 0;
            int num = x;
            while (hs.contains(num)) {
                hs.remove(num);
                num++;
                c++;
            }
            max = Math.max(max, c);
        }
        return max;
    }
}