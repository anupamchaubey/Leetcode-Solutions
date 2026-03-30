class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] leftMostIndex=new int[26];
        Arrays.fill(leftMostIndex, -1);
        int[] rightMostIndex=new int[26];
        Arrays.fill(rightMostIndex, -1);

        int n=s.length();
        int count=0;

        for(int i=0;i<n;i++){
            if(leftMostIndex[s.charAt(i)-'a']==-1){
                leftMostIndex[s.charAt(i)-'a']=i;
            }
            rightMostIndex[s.charAt(i)-'a']=i;
        }
        int c=0;
        
        for(int i=0;i<26;i++){
            Set<Character> hs=  new HashSet<>();
            if(leftMostIndex[i]!=-1 && rightMostIndex[i]!=-1){
                int p=leftMostIndex[i];
                int q=rightMostIndex[i];
                for(int j=p+1;j<q;j++){
                    hs.add(s.charAt(j));
                }
                c+=hs.size();
            }
        }
        return c;
    }
}