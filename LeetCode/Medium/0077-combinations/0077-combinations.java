class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        rec(n, k, 1, new ArrayList<>());
        return ans;
    }
    void rec(int n, int k, int x, List<Integer> ls){
        if(ls.size()==k){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=x;i<=n;i++){
            ls.add(i);
            rec(n, k, i+1, ls);
            ls.remove(ls.size()-1);
        }
    }
}