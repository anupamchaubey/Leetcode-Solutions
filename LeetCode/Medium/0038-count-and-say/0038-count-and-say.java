class Solution {
    public String countAndSay(int n) {
        String ans="1";
        while(n>1){
            n--;
            ans=say(ans);
        }
        return ans;
    }
    private String say(String s){
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            int cnt=1;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                i++;
                cnt++;
            }
            sb.append(cnt).append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}