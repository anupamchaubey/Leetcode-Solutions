class Solution {
    // prefix dp
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        HashSet<String> hs= new HashSet<>();
        for(String str: wordDict)hs.add(str);

        List<String>[] dp= new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String word = s.substring(j, i);
                if(hs.contains(word)){
                    for(String prev: dp[j]){
                        if(prev.isEmpty()){
                            dp[i].add(word);
                        }else{
                            dp[i].add(prev+" "+word);
                        }
                    }
                }
            }
        }
        return dp[n];
    }

    // void rec(String s, HashSet<String> hs, String str, int i, int j) {
    //     if (i >= s.length()) {
    //         ans.add(str.trim());
    //     }
    //     if (j > s.length())
    //         return;
    //     if (hs.contains(s.substring(i, j))) {
    //         rec(s, hs, str + s.substring(i, j) + " ", j, j + 1);
    //     }
    //     rec(s, hs, str, i, j + 1);
    // }
}