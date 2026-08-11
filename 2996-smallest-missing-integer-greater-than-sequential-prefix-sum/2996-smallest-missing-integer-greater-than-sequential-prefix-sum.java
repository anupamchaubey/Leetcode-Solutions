class Solution {
    public int missingInteger(int[] nums) {

        int len = 1;
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                len++;
                sum += nums[i];
            } else
                break;
        }

        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums)
            hs.add(x);
        for (int i = sum; i <= 3000; i++) {
            if (!hs.contains(i))
                return i;
        }
        return -1;
    }
}