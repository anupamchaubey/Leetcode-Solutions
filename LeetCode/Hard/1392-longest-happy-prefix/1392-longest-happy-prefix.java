class Solution {
    public String longestPrefix(String s) {
        int n=s.length();
        int[] lps=new int[n];
        int len=0;
        for(int i=1;i<n;){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len==0){
                    lps[i]=0;
                    i++;
                }else{
                    len=lps[len-1];
                }
            }
        }
        return s.substring(0, lps[s.length()-1]);
    }
}