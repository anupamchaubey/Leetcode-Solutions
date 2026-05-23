class Solution {
    int[][] memo;
    public int minInsertions(String s) {
        memo=new int[s.length()][s.length()];
        for(int[] m: memo)Arrays.fill(m, -1);
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return s.length()-rec(s, sb.toString(), 0, 0);
    }
    int rec(String s1, String s2, int i, int j){
        if(i==s1.length() || j==s2.length())return 0;
        if(memo[i][j]!=-1)return memo[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return memo[i][j]= 1+rec(s1, s2, i+1, j+1);
        }else{
            return memo[i][j]= Math.max(rec(s1, s2, i+1, j), rec(s1, s2, i, j+1));
        }
    }
}