class Solution {
    public int minMoves(int[] nums) {
        // incrementing $n-1$ elements by 1 is relative to decrementing the remaining 1 element by 1.
        int min = nums[0];
        for (int i : nums) {
            if (i < min)
                min = i;
        }
        int c = 0;
        for (int i : nums) {
            c += i - min;
        }
        return c;
    }
}