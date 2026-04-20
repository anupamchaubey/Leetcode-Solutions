class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int l = 0;
        int r = -1;
        for (int i = 0; i < bloomDay.length; i++) {
            r = Math.max(r, bloomDay[i]);
        }
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    boolean canMake(int[] bloomDay, int m, int k, int days) {

        int mi = 0;// how many bouquets
        int c = 0;// how many flowers

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                c++;
                if (c == k) {
                    c = 0;
                    mi += 1;// one bouquet is made
                }
            } else {
                c = 0;
            }

            if (mi == m)
                return true;

        }
        return mi == m;
    }
}