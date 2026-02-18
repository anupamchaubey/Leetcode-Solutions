class Solution {
    int[] parent;
    int[] rank;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //email ko ek unique id deni h
        HashMap<String, Integer> emailToId= new HashMap<>();
        //email ko uske account name ke sath associate krna h 
        HashMap<String, String> emailToName=new HashMap<>();
        int id=0;
        for(List<String> acc:accounts){
            String name=acc.get(0);
            for(int i=1;i<acc.size();i++){
                String email=acc.get(i);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email, id++);
                }
                emailToName.put(email, name);
            }
        }
        int component=id;
        parent=new int[id];
        rank=new int[id];
        for(int i=0;i<id;i++){
            parent[i]=i;
            rank[i]=0;
        }
        //same account ke mail ko merge krna h
        for(List<String> acc:accounts){
            if(acc.size()<=2)continue;
            int firstAccountId=emailToId.get(acc.get(1));//first account ki id 
            for(int k=2;k<acc.size();k++){//first acc ke mail ko sbke sath merge kr do
                union(firstAccountId, emailToId.get(acc.get(k)), parent, rank);
            }
        }
        HashMap<Integer, List<String>> groupToId=new HashMap<>();
        for(String email:emailToId.keySet()){
            int EmailId=emailToId.get(email);
            int root=find(EmailId, parent);
            if(!groupToId.containsKey(root)){
                groupToId.put(root, new ArrayList<>());
            }
            groupToId.get(root).add(email);
        }
        //final step
        List<List<String>> ans=new ArrayList<>();
        for(Integer node: groupToId.keySet()){
            List<String> merge=groupToId.get(node);
            Collections.sort(merge);
            List<String> list=new ArrayList<>();
            list.add(emailToName.get(merge.get(0)));
            list.addAll(merge);
            ans.add(list);
        }
        return ans;


    }
    int find(int x, int[] parent){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x], parent);
    }
    boolean union(int x, int y, int[] parent, int[] rank){
        int px=find(x, parent);
        int py=find(y, parent);
        if(px==py)return false;
        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(rank[py]>rank[px]){
            parent[px]=py;
        }else{
            parent[py]=px;
            rank[px]++;
        }
        return true;
    }
}