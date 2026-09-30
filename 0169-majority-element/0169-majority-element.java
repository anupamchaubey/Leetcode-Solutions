class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int maxFreq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                maxFreq += 1;
            } else {
                maxFreq -= 1;
                if (maxFreq < 0) {
                    num = nums[i];
                    maxFreq = 1;
                }
            }
        }
        return num;
    }
}