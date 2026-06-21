class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                StringBuilder sb = new StringBuilder(String.valueOf(sum));
                if (sb.charAt(0) - '0' == x && sb.charAt(sb.length() - 1) - '0' == x)
                    c++;
            }
        }
        return c;
    }
}