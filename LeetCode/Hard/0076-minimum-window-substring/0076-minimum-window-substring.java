class Solution {
    public String minWindow(String s, String t) {
        int[] need=new int[128];
        for(char ch: t.toCharArray()){
            need[ch]++;
        }
        int req=t.length();
        int start=0;
        int left=0;
        int minLength=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            if(need[s.charAt(right)]>0){
                req--;
            }
            need[s.charAt(right)]--;

            while(req==0){
                if(right-left+1<minLength){
                    minLength=right-left+1;
                    start=left;
                }
                need[s.charAt(left)]++;
                if(need[s.charAt(left)]>0){
                    req++;
                }
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE ? "": s.substring(start, start+minLength);
    }
}