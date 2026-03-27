class Solution {
    // // prefix dp
    public boolean wordBreak(String s, List<String> dict) {
    //     int n=s.length();
    //     Set<String> hs= new HashSet<>();
    //     for(String str: dict)hs.add(str);
    //     boolean[] dp= new boolean[n+1];
    //     dp[0]=true;
    //     for(int i=1;i<=n;i++){
    //         for(int j=0;j<i;j++){
    //             if(dp[j] && hs.contains(s.substring(j, i)))dp[i]=true;
    //         }
    //     }
    //     return dp[n];
        int n=s.length();
        Set<String> hs= new HashSet<>();
        for(String str: dict)hs.add(str);
        return rec(s, 0, 1, hs);
    }
    boolean rec(String s, int i, int j, Set<String> hs){
        if(i==s.length())return true;
        if (j > s.length()) return false;
        if(hs.contains(s.substring(i, j))){
            return rec(s, j, j+1, hs)|| rec(s, i, j+1, hs);
        }
        else return rec(s, i, j+1, hs);
    }
}