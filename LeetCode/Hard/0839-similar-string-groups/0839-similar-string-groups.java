class Solution {
    int[] parent;
    int[] size;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py)
            return false;

        if (size[py] > size[px]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
        return true;
    }
    boolean isSimilar(String s1, String s2){
        int diff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
                if(diff>2)return false;
            }
        }
        return true;
    }

    public int numSimilarGroups(String[] strs) {
        parent = new int[strs.length];
        size = new int[strs.length];
        HashSet<String> hs = new HashSet<>();
        for (String s : strs) {
            hs.add(s);
        }

        for(int i=0;i<strs.length;i++){
            parent[i]=i;
            size[i]=1;
        }
        
        int total = strs.length;
        
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                if(isSimilar(strs[i], strs[j])){
                    if(find(i)!=find(j)){
                        union(i, j);
                        total--;
                    }
                }
            }
        }
        return total;

    }
}