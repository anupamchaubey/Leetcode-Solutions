class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans=strs[0];
        for(int i=1;i<strs.length;i++){
            String x=strs[i];
            String y=ans;
            int j=0;
            while(j<x.length() && j<y.length()){
                if(x.charAt(j)!=y.charAt(j))break;
                j++;
            }
            ans=x.substring(0, j);
        }
        return ans;
    }
}