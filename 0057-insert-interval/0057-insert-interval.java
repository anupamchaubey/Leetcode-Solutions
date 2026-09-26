class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            ls.add(intervals[i]);
        }
        ls.add(newInterval);
        Collections.sort(ls, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        int en = -1, st = Integer.MAX_VALUE;
        for (int i = 0; i < ls.size(); i++) {
            if (en == -1 || ls.get(i)[0] <= en) {
                st = Math.min(st, ls.get(i)[0]);
                en = Math.max(en, ls.get(i)[1]);
            } else {
                ans.add(new int[] { st, en });
                st = ls.get(i)[0];
                en = ls.get(i)[1];
            }
        }
        ans.add(new int[] { st, en });
        int[][] arr = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            arr[i][0] = ans.get(i)[0];
            arr[i][1] = ans.get(i)[1];
        }
        return arr;
    }
}