class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt=0;
        for(List<String> ls: items){
            String t=ls.get(0);
            String c=ls.get(1);
            String n=ls.get(2);
            if(ruleKey.equals("type") && ruleValue.equals(t) || ruleKey.equals("color") && ruleValue.equals(c) || ruleKey.equals("name") && ruleValue.equals(n))cnt++;
        }
        return cnt;
    }
}