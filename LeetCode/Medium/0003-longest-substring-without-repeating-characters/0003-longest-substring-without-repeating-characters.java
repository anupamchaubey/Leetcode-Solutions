class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        HashSet<Character> hs= new HashSet<>();
        int max=0;
        for(int i=0;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                while(hs.contains(s.charAt(i))){
                    hs.remove(s.charAt(left));
                    left++;
                }
            }
            hs.add(s.charAt(i));
            max=Math.max(max, hs.size());
        }
        return max;
    }
}