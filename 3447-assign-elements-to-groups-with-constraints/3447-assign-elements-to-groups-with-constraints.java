class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int[] arr = new int[groups.length];

        int[] sieve = new int[100001];
        Arrays.fill(sieve, -1);
        for (int i = 0; i < elements.length; i++) {
            int x = elements[i];
            if (sieve[x] == -1) {
                for (int j = x; j < sieve.length; j += x) {
                    if (sieve[j] != -1)
                        continue;
                    sieve[j] = i;
                }
            }
        }
        for (int i = 0; i < groups.length; i++) {
            arr[i] = sieve[groups[i]];
        }
        return arr;
    }
}