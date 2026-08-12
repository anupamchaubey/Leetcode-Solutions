class Solution {
    public int trap(int[] height) {
        int[] right = new int[height.length];
        int[] left = new int[height.length];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int level = Math.min(left[i], right[i]);
            water += Math.max(0, level - height[i]);
        }
        return water;
    }
}