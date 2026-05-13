class Solution {
    boolean[][] pal;
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        pal=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            pal[i][i]=true;
        }
        for(int j=0;j<s.length();j++){
            for(int i=j-1;i>=0;i--){
                int len=j-i+1;
                if(len==2){
                    pal[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    pal[i][j]=pal[i+1][j-1] && s.charAt(i)==s.charAt(j);
                }
            }
        }
        rec(s, 0, new ArrayList<>());
        return ans;
    }
    void rec(String s, int idx, List<String> ls){
        if(idx==s.length()){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(pal[idx][i]){
                ls.add(s.substring(idx, i+1));
                rec(s, i+1, ls);
                ls.remove(ls.size()-1);
            }
        }
    }
}