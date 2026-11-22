class Solution {
    public int countDominantElements(int[] nums) {
        if (nums.length == 1)
            return 1;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i - 1 >= 0 && i + 1 < nums.length) {
                double avg = (nums[i - 1] + nums[i + 1]) / 2.0;
                if (nums[i] >= avg)
                    cnt++;
            } else if (i + 1 < nums.length) {
                if (nums[i] >= nums[i + 1])
                    cnt++;
            } else {
                if (nums[i] >= nums[i - 1])
                    cnt++;
            }
        }
        return cnt;
    }
}