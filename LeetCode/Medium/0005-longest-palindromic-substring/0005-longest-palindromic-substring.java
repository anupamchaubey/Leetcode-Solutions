class Solution {
    public String longestPalindrome(String s) {
        int max=0;
        int st=0,en=0;
        int n=s.length();
        if(n==0)return "";
        boolean[][] pal=new boolean[n][n];
        for(int j=0;j<n;j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2 || pal[i+1][j-1]){
                        pal[i][j]=true;
                        if(j-i+1>max){
                            max=j-i+1;
                            st=i;
                            en=j;
                        }
                    }
                }
            }
        }
        return s.substring(st, en+1);
    }
}