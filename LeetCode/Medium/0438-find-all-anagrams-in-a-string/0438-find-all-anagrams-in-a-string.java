class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans= new ArrayList<>();
        if(s.length()<p.length())return ans;

        int[] freq1=new int[26];
        int[] freq2=new int[26];

        for(int i=0;i<p.length();i++){
            freq1[s.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            freq2[p.charAt(i)-'a']++;
        }

        if(Arrays.equals(freq1, freq2))ans.add(0);
        int l=0;
        for(int i=p.length();i<s.length();i++, l++){
            freq1[s.charAt(i)-'a']++;
            freq1[s.charAt(l)-'a']--;
            if(Arrays.equals(freq1, freq2)){
                ans.add(l+1);
            }
        }
        return ans;
    }
}