class Solution {
    HashMap<Integer, Set<Integer>> hm;
    
    public int minJumps(int[] arr) {
        hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.putIfAbsent(arr[i], new HashSet<>());
            hm.get(arr[i]).add(i);
        }
        boolean[] visited=new boolean[arr.length];
        visited[0]=true;

        Queue<Integer> q=new LinkedList<>();
        int jumps=0;
        q.offer(0);

        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int x=q.poll();
                if(x==arr.length-1)return jumps;
                if(x-1>=0 && !visited[x-1]){
                    visited[x-1]=true;
                    q.offer(x-1);
                }
                if(x+1<arr.length && !visited[x+1]){
                    visited[x+1]=true;
                    q.offer(x+1);
                }
                if(hm.containsKey(arr[x]))
                for(int idx: hm.get(arr[x])){
                    if(idx!=x && !visited[idx]){
                        visited[idx]=true;
                        q.offer(idx);
                    }
                    hm.remove(arr[x]);
                }
                
            }
            jumps++;
        }
        return -1;
    }
}