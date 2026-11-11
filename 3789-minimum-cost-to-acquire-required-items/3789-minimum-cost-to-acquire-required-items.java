class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long sum1 = 0L;
        long sum2 = 0L;
        long sum3 = 0L;
        sum1 += (long) need1 * cost1;
        sum1 += (long) need2 * cost2;
        int x = Math.max(need1, need2);
        sum2 += (long) x * costBoth;
        x = Math.min(need1, need2);
        sum3 += (long) x * costBoth;
        if (need1 < need2) {
            sum3 += (long) cost2 * (need2 - x);
        } else {
            sum3 += (long) cost1 * (need1 - x);
        }
        return Math.min(sum1, Math.min(sum2, sum3));
    }
}