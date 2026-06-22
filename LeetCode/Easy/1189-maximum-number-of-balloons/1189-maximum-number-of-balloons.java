class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        String s = "balloon";
        for (char ch : s.toCharArray()) {
            if(ch=='l' || ch=='o'){
                min = Math.min(min, freq[ch - 'a']/2);
            }
            else min = Math.min(min, freq[ch - 'a']);
        }
        return min;
    }
}