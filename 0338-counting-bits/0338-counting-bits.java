class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int shift = 0;
            while ((1 << shift) <= i)
                shift++;
            int x = (1 << (shift - 1));
            arr[i] = arr[i - x] + 1;
        }
        return arr;
    }
}