class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cnt=0;
        Arrays.sort(intervals, (a, b)-> a[1]-b[1]);
        int end=Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            if(end<=intervals[i][0]){
                cnt++;
                end=intervals[i][1];
            }
        }
        return intervals.length-cnt;
    }
}