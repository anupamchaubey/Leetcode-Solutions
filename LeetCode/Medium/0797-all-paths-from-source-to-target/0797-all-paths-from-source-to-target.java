class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> ans= new ArrayList<>();
        
        Queue<List<Integer>> q= new LinkedList<>();
        List<Integer> src=new ArrayList<>();
        src.add(0);
        q.offer(src);

        while(!q.isEmpty()){
            List<Integer> ls=q.poll();
            if(ls.get(ls.size()-1)==n-1){
                ans.add(new ArrayList<>(ls));
            }
            for(int v: graph[ls.get(ls.size()-1)]){
                if(ls.get(ls.size()-1)!=n-1){
                    List<Integer> list=new ArrayList<>(ls);
                    list.add(v);
                    q.offer(list);
                }
            }
        }
        return ans;
    }
}