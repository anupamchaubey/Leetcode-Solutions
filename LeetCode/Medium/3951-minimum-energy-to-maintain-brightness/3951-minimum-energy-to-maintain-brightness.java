class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        long ans = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int st = intervals[0][0], en = intervals[0][1];

        int bulbs = (brightness + 2) / 3;

        long len = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > en) {
                len += en - st + 1;
                st = intervals[i][0];
                en = intervals[i][1];
            } else {
                en = Math.max(en, intervals[i][1]);
            }
        }
        len += en - st + 1;
        return len * bulbs;
    }
}