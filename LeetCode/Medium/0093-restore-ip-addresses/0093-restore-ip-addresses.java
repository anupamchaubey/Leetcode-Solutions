class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        rec(s, 0, "", 0);
        return ans;
    }

    void rec(String s, int idx, String str, int parts) {
        if (idx == s.length() && parts==4) {
            ans.add(str.substring(0, str.length()-1));
            return;
        }
        for (int i = idx;i<idx+3 && i < s.length(); i++) {
            
            if (isValid(s.substring(idx, i+1))) {
                
                rec(s, i+1, str + s.substring(idx, i+1) + ".", parts+1 );
            }
        }

    }
    boolean isValid(String str) {
        if(str.length()>1 && str.charAt(0)=='0')return false;
        int x=Integer.parseInt(str);
        return x>=0 && x<=255;
    }
}