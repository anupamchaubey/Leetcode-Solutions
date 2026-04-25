class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ls= new ArrayList<>();

        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        
        int[] curr= intervals[0];

        ls.add(curr);

        for(int[] interval: intervals){
            int currEnd=curr[1];
            int nextStart=interval[0];
            int nextEnd=interval[1];

            if(currEnd>=nextStart){
                curr[1]=Math.max(currEnd, nextEnd);
            }else{
                curr=interval;
                ls.add(curr);
            }
        }
        return ls.toArray(new int[ls.size()][]);
    }
}