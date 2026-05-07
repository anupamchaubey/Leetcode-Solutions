class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderUsedForHeightDiff=new PriorityQueue<>();

        int n=heights.length;
        for(int i=1;i<n;i++){
            int diff=heights[i]-heights[i-1];
            if(diff<=0)continue;
            
            ladderUsedForHeightDiff.offer(diff);

            if(ladderUsedForHeightDiff.size()>ladders){
                bricks-=ladderUsedForHeightDiff.poll();
            }
            if(bricks<0){
                return i-1;
            }
        }
        return heights.length-1;
    }
}