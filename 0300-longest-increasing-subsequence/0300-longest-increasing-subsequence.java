class Solution {
    public int lengthOfLIS(int[] nums) {
        //here we will use the tails method
        int[] tails = new int[nums.length];
        Arrays.fill(tails, Integer.MAX_VALUE);
        int lis = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            //place x at correct index in tails array bu thinking that tails[i]=minimum number ending for lis of length i+1

            int l = 0, r = i - 1;
            while (l <= r) {
                int mid = l + (r - l / 2);
                if (x <= tails[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            tails[l] = x;
            lis = Math.max(lis, l + 1);
        }
        return lis;
    }
}