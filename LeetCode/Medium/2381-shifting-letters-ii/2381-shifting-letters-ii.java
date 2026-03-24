class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff=new int[s.length()];
        for(int[] sh: shifts){
            int l=sh[0];
            int r=sh[1];
            int d=sh[2];
            if(d==1){
                diff[l]+=1;
                if(r+1<s.length()){
                    diff[r+1]-=1;
                }
            }else{
                diff[l]-=1;
                if(r+1<s.length()){
                    diff[r+1]+=1;
                }
            }
        }
        for(int i=1;i<diff.length;i++){
            diff[i]+=diff[i-1];
        }
        char[] arr= s.toCharArray();
        for(int i=0;i<s.length();i++){
            int shift=diff[i]%26;

            int newChar=(arr[i]-'a' +shift +26)%26;
            arr[i]=(char)('a'+newChar);
        }
        String ans=new String(arr);
        return ans;
    }
}