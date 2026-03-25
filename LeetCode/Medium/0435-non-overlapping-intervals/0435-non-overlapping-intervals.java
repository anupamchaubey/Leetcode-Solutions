class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1], b[1]));
        int count=0;
        int currTime=Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<currTime){
                count++;
            }else{
                currTime=intervals[i][1];
            }
        }
        return count;
    }
}