class Solution {
    int[] parent;
    int[] size;

    int find(int x){
        if(x!=parent[x]){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    boolean union(int x, int y){
        int px=find(x);
        int py=find(y);

        if(px==py)return false;
        if(size[px]>size[py]){
            parent[py]=px;
            size[px]+=size[py];
        }else{
            parent[px]=py;
            size[py]+=size[px];
        }
        return true;
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent=new int[s.length()];
        size=new int[s.length()];
        for(int i=0;i<s.length();i++){
            parent[i]=i;
            size[i]=1;
        }
        for(List<Integer> ls:pairs){
            int x=ls.get(0);
            int y=ls.get(1);
            union(x,y);
        }
        HashMap<Integer, PriorityQueue<Character>> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.putIfAbsent(find(i), new PriorityQueue<>());
            hm.get(find(i)).offer(s.charAt(i));
        }
        char[] arr= new char[s.length()];
        for(int i=0;i<arr.length;i++){
            int px=find(i);
            arr[i]=hm.get(px).poll();
        }
        return new String(arr);
    }
}