class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return 0;

        int max = 0;

        for (int k = 0; k < n; k++) {
            int[] arr = new int[nums.length - 1];
            int p = 0;
            for (int j = 0; j < n; j++) {
                if (j == k)
                    continue;
                arr[p++] = nums[j];
            }
            int[] gcdPrefix = new int[nums.length - 1];
            int[] gcdSuffix = new int[nums.length - 1];
            gcdSuffix[arr.length - 1] = arr[arr.length - 1];
            gcdPrefix[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                gcdPrefix[i] = gcd(gcdPrefix[i - 1], arr[i]);
            }
            for (int i = arr.length - 2; i >= 0; i--) {
                gcdSuffix[i] = gcd(gcdSuffix[i + 1], arr[i]);
            }
            int c = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (gcdPrefix[i] == gcdSuffix[i + 1])
                    c++;
            }
            max = Math.max(max, c);
        }
        //if we don't remove
        int[] gcdPrefix = new int[nums.length];
        int[] gcdSuffix = new int[nums.length];
        gcdSuffix[n - 1] = nums[n - 1];
        gcdPrefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcdPrefix[i] = gcd(gcdPrefix[i - 1], nums[i]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            gcdSuffix[i] = gcd(gcdSuffix[i + 1], nums[i]);
        }
        int c = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (gcdPrefix[i] == gcdSuffix[i + 1])
                c++;
        }
        max = Math.max(max, c);
        return max;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}