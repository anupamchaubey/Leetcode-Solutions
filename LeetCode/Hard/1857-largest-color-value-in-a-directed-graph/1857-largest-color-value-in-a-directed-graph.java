class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        int m=edges.length;
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        int[][] dp= new int[n][26];

        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                dp[i][colors.charAt(i)-'a']=1;
                q.offer(i);
            }
        }
        int ans=-1;
        int visited=0;
        while(!q.isEmpty()){
            int u=q.poll();
            visited++;
            for(int c=0;c<26;c++){
                ans=Math.max(ans, dp[u][c]);
            }
            for(int v:adj.get(u)){
                
                for(int c=0;c<26;c++){
                    dp[v][c]=Math.max(dp[v][c], dp[u][c]);
                }
                indegree[v]--;
                if(indegree[v]==0){
                    dp[v][colors.charAt(v)-'a']++;
                    q.offer(v);
                }
            }
        }
        if(visited!=n)return -1;
        return ans;
    }
}