class Solution {

    // look there written atmost k times
    // remember pattern atmost k distinct ?

    public int characterReplacement(String s, int k) {
        return atmostk(s, k);
    }
    int atmostk(String s, int k){
        
        int[] freq= new int[128];
        int ans=0;
        int l=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
            max=Math.max(max, freq[s.charAt(i)]);

            while(i-l+1-max>k){
                
                
                freq[s.charAt(l)]--;
                l++;
            }
            ans=Math.max(ans, i-l+1);
        }
        return ans;
        
    }
}