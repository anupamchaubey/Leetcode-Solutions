class Solution {
    public String longestPalindrome(String s) {
        int max=0;
        int st=0,en=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPal(s, i, j)){
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