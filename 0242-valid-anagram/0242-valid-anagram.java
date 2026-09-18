class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cntS=new int[26];
        int[] cntT=new int[26];
        for(char ch: s.toCharArray()){
            cntS[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            cntT[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(cntS[i]!=cntT[i])return false;
        }
        return true;
    }
}