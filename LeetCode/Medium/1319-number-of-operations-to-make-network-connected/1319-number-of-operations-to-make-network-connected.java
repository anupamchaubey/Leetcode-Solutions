class Solution {
    int[] parent;
    int[] size;

    int find(int x) {
        if (parent[x] != x)
            return parent[x]=find(parent[x]);
        return x;
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py)
            return false;
        if (size[px] > size[py]) {
            parent[py] = px;
        } else if (size[py] > size[px]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            size[py] += size[px];
        }
        return true;
    }

    public int makeConnected(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i]=1;
        }
        int extra=0;
        for(int i=0;i<edges.length;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            if(!union(x, y))extra++;
        }
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<n;i++)hs.add(find(i));
        int need=hs.size()-1;
        if(need>extra)return -1;
        return need;
    }
}