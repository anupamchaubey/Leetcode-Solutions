class Solution {
    public int furthestBuilding(int[] nums, int bricks, int ladders) {
        int n=nums.length;

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<n;i++){
            int diff=nums[i]-nums[i-1];
            if(diff<=0)continue;
            
            pq.offer(diff);

            if(pq.size()>ladders){
                bricks-=pq.poll();
            }
            if(bricks<0){
                return i-1;
            }
        }
        return n-1;
    }
}