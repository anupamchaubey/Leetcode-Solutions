class Solution {
    List<String> ls;
    public List<String> generateParenthesis(int n) {
        ls=new ArrayList<>();
        rec(2*n, "");
        return ls;
    }
    void rec(int len, String s){
        if(s.length()==len){
            if(correct(s)){
                ls.add(s);
            }
            return;
        }
        rec(len, s+"(");
        rec(len, s+")");
    }
    boolean correct(String s){
        int open=0, close=0;
        for(char ch: s.toCharArray()){
            if(ch=='(')open++;
            else close++;
            if(close>open)return false;
        }
        return open==close;
    }
}