class Solution {
    public String longestPalindrome(String s) {
        if("".equals(s))return s;
        String ans=s.charAt(0)+"";
        for(int i=0;i<s.length();i++){
            if(i-1>=0 && i+1<s.length() && s.charAt(i-1)==s.charAt(i+1)){
                int p=i-1, q=i+1;
                while(p>=0 && q<s.length() && s.charAt(p)==s.charAt(q)){
                    p--;
                    q++;
                }
                if(s.substring(p+1, q).length()>ans.length()){
                    ans=s.substring(p+1, q);
                }
            }
            if(i-1>=0 && s.charAt(i)==s.charAt(i-1)){
                int p=i-1, q=i;
                while(p>=0 && q<s.length() && s.charAt(p)==s.charAt(q)){
                    p--;
                    q++;
                }
                if(s.substring(p+1, q).length()>ans.length()){
                    ans=s.substring(p+1, q);
                }
            }
        }
        return ans;
    }
}