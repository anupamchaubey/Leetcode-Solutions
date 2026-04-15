class Solution {
    class Pair {
        int num, idx;

        Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.num - a.num);
        
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(nums[i], i));
            while (!pq.isEmpty() && pq.peek().idx <= (i - k)) {
                pq.poll();
            }
            if(i>=k-1){
                arr[i-k+1]=pq.peek().num;
            }
            
        }
        return arr;
    }
}