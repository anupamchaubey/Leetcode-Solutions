class Solution {
    public List<String> partitionString(String s) {
        List<String> ls= new ArrayList<>();
        HashSet<String> hs= new HashSet<>();
        int st=0;
        for(int j=1;j<=s.length();j++){
            if(!hs.contains(s.substring(st, j))){
                hs.add(s.substring(st, j));
                ls.add(s.substring(st, j));
                st=j;
            }
        }
        return ls;
    }
}