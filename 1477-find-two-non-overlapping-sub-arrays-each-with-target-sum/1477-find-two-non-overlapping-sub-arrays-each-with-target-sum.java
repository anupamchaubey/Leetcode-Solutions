class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int[] prefix = new int[arr.length];
        Arrays.fill(prefix, Integer.MAX_VALUE);

        int sum = 0;
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[l++];
            }
            if (sum == target) {
                if (i > 0) {
                    prefix[i] = Math.min(prefix[i - 1], i - l + 1);
                } else {
                    prefix[i] = i - l + 1;
                }
            } else if (i > 0)
                prefix[i] = prefix[i - 1];
        }
        int[] suffix = new int[arr.length];
        Arrays.fill(suffix, Integer.MAX_VALUE);
        sum = 0;
        int r = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[r--];
            }
            if (sum == target) {
                if (i < arr.length - 1) {
                    suffix[i] = Math.min(suffix[i + 1], r - i + 1);
                } else {
                    suffix[i] = r - i + 1;
                }
            } else {
                if (i < arr.length - 1) {
                    suffix[i] = suffix[i + 1];
                }
            }
        }
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            if (prefix[i] != Integer.MAX_VALUE && suffix[i + 1] != Integer.MAX_VALUE) {
                minSum = Math.min(minSum, prefix[i] + suffix[i + 1]);
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}