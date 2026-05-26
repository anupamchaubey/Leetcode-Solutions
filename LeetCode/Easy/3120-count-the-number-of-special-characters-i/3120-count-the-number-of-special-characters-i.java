class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq=new int[26];
        int[] freq2=new int[26];
        int cnt=0;
        for(char ch: word.toCharArray()){
            
            if(ch>='a' && ch<='z'){
                freq[ch-'a']++;
            }else{
                
                freq2[ch-'A']++;
                
            }
        }
        HashSet<Character> hs=new HashSet<>();
        for(char ch: word.toCharArray()){
            if(hs.contains(ch))continue;
            if(freq[Character.toLowerCase(ch)-'a']>0 && freq2[Character.toUpperCase(ch)-'A']>0)cnt++;
            hs.add(Character.toLowerCase(ch));
            hs.add(Character.toUpperCase(ch));
        }
        return cnt;
    }
}