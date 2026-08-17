class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = piles[0];
        for (int x : piles)
            r = Math.max(r, x);
        int ans = -1;
        int l = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValid(piles, mid, h)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    boolean isValid(int[] piles, int speed, int h) {
        long hrs = 0;
        for (int i = 0; i < piles.length; i++) {
            hrs += ((piles[i] + speed - 1) / speed);
        }
        return hrs <= h;
    }
}