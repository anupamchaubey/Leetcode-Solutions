class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int x:nums){
            hm.put(x, hm.getOrDefault(x, 0)+1);
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>((a, b)-> Integer.compare(hm.get(b), hm.get(a)));
        for(int x:hm.keySet()){
            pq.offer(x);
        }
        int[] ans= new int[k];
        int l=0;
        for(int i=0;i<k;i++){
            ans[l++]=pq.poll();
        }
        return ans;
    }
}