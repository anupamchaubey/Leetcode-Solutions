class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)return 0;
        HashMap<Integer, List<Integer>> hm= new HashMap<>();//stops-->routes
        for(int i=0;i<routes.length;i++){
            for(int j: routes[i]){
                hm.putIfAbsent(j, new ArrayList<>());
                hm.get(j).add(i);
            }
        }
        if(!hm.containsKey(source))return -1;
        boolean[] visited=new boolean[routes.length];
        Queue<Integer> q= new LinkedList<>();
        for(int x: hm.get(source)){
            visited[x]=true;
            q.offer(x);
        }
        int buses=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int x=q.poll();
                for(int v:routes[x]){
                    if(v==target)return buses;
                    for(int r: hm.get(v)){
                        if(!visited[r]){
                            visited[r]=true;
                            q.offer(r);
                        }
                    }
                }
                buses++;
            }
        }
        return -1;
    }
}