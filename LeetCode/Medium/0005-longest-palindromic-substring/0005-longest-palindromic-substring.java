class Solution {
    public String longestPalindrome(String s) {
        boolean[][] pal=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2 || pal[i+1][j-1]){
                        pal[i][j]=true;
                    }
                }
            }
        }
        int max=0;
        int st=0,en=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(pal[i][j]){
                    if(max<j-i+1){
                        max=j-i+1;
                        st=i;
                        en=j;
                    }
                }
            }
        }
        return s.substring(st, en+1);
    }
    boolean isPal(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}