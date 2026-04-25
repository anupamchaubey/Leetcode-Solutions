class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int x:stones){
            pq.offer(x);
        }

        while(pq.size()>=2){
            int x=pq.poll();
            int y=pq.poll();
            int smash=x-y;
            if(smash>0){
                pq.offer(smash);
            }
        }
        if(pq.isEmpty())return 0;
        return pq.poll();
    }
}