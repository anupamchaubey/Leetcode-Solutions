class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0]- b[0]);
        List<int[]> ls=new ArrayList<>();
        int last=intervals[0][1];
        int st=intervals[0][0];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<=last){
                last=Math.max(last, intervals[i][1]);
            }else{
                ls.add(new int[]{st, last});
                st=intervals[i][0];
                last=intervals[i][1];
            }
        }
        ls.add(new int[]{st, last});
        return ls.toArray(new int[ls.size()][]);
    }
}