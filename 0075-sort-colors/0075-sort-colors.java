class Solution {
    public void sortColors(int[] nums) {
        int oStart = 0;
        int end = nums.length - 1;
        for (int i = 0; i <= end;) {
            if (nums[i] == 0) {
                int temp = nums[oStart];
                nums[oStart++] = nums[i];
                nums[i] = temp;
                i++;
            } else if (nums[i] == 1) {
                i++;
                continue;
            } else {
                int temp = nums[end];
                nums[end--] = nums[i];
                nums[i] = temp;
            }
        }
    }
}