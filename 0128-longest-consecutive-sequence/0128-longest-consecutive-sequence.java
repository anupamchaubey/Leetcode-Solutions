class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums)
            hs.add(x);
        int max = 0;
        for (int x : nums) {
            if (!hs.contains(x))
                continue;
            hs.remove(x);
            int c = 1;
            int num = x + 1;
            while (hs.contains(num)) {
                hs.remove(num);
                num++;
                c++;
            }
            num = x - 1;
            while (hs.contains(num)) {
                hs.remove(num);
                num--;
                c++;
            }
            max = Math.max(max, c);
        }
        return max;
    }
}