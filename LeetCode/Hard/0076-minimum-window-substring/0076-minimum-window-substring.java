class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[128];
        for(char ch: t.toCharArray()){
            freq[ch]++;
        }
        int left=0;
        int need=t.length();
        int start=0;
        int max=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            if(freq[s.charAt(right)]>0){
                need--;
            }
            freq[s.charAt(right)]--;
            while(need==0){
                if(right-left+1<max){
                    max=right-left+1;
                    start=left;
                }
                if(freq[s.charAt(left)]==0){
                    need++;
                }
                freq[s.charAt(left)]++;
                left++;
            }
        }
        if(max==Integer.MAX_VALUE)return "";
        return s.substring(start, start+max);
    }
}