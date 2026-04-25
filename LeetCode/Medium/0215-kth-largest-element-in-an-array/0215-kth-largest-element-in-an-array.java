class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length<k)return -1;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int x: nums){
            pq.offer(x);
        }
        while(pq.size()>k){
            pq.poll();
        }
        return pq.poll();
        
    }
}