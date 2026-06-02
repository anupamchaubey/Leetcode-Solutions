class Solution {
    int p = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while (j < arr.length && arr[j] > arr[i])
                j++;
            right[i] = j;
            j = i - 1;
            while (j >= 0 && arr[j] >= arr[i])
                j--;
            left[i] = j;
        }
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long x = (i - left[i]) * (right[i] - i);
            sum = (sum + x * arr[i]) % p;
        }
        return (int) sum;
    }
}