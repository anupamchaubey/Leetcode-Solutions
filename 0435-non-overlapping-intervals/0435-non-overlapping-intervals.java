class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> ls=new ArrayList<>();
        for(int[] arr: intervals)ls.add(arr);
        Collections.sort(ls, (a, b)-> {
            if(a[1]!=b[1])return Integer.compare(a[1], b[1]);
            return a[0]-b[0];
        });
        int cnt=0;
        int en=ls.get(0)[1];
        for(int i=1;i<ls.size();i++){
            if(ls.get(i)[0]<en){
                cnt++;
            }else{
                en=ls.get(i)[1];
            }
        }
        return cnt;
    }
}