class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm= new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i))!=t.charAt(i))return false;
            hm.put(s.charAt(i), t.charAt(i));
        }
        HashSet<Character> hs= new HashSet();
        for(char ch: hm.values()){
            if(hs.contains(ch))return false;
            hs.add(ch);
        }
        return true;
    }
}