class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[128];
        for(char ch:t.toCharArray()){
            freq[ch]--;
        }

        int count=t.length();

        int min=Integer.MAX_VALUE;
        int st=-1;
        int en=-1;

        int l=0;

        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)]<0)count--;
            freq[s.charAt(i)]++;
            
            while(l<s.length() && count==0){
                freq[s.charAt(l)]--;
                if(freq[s.charAt(l)]<0)count++;
                if(min>i-l+1){
                    min=Math.min(min, i-l+1);
                    st=l;
                    en=i+1;
                }
                l++;
            }
        }
        if(st==-1)return "";
        return s.substring(st, en);
    }

}