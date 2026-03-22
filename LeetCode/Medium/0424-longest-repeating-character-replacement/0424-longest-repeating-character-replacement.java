class Solution {
    public int characterReplacement(String s, int k) {
        return atmost(s, k);
    }
    int atmost(String s, int k){
        int[] freq=new int[26];
        int maxfreq=0;
        int max=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'A']++;
            maxfreq=Math.max(freq[s.charAt(i)-'A'], maxfreq);

            while((i-left+1)-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            for(int x: freq)maxfreq=Math.max(maxfreq, x);
            max=Math.max(max, i-left+1);
        }
        return max;
    }
}