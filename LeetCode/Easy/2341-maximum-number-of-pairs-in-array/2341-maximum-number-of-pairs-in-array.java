class Solution {
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        int x = 0, y = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                x++;
                i += 2;
            } else {
                y++;
                i++;
            }
        }
        if (i == nums.length - 1)
            y++;
        return new int[] { x, y };
    }
}