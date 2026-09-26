class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> ls = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            ls.add(intervals[i]);
        }
        Collections.sort(ls, (a, b) -> {
            if (a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int cnt = 0;
        int en = ls.get(0)[1];
        for (int i = 1; i < ls.size(); i++) {
            if (ls.get(i)[0] < en) {
                cnt++;
            } else {
                en = ls.get(i)[1];
            }
        }
        return cnt;
    }
}