class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        hm.put(-1, 0);
        int c=0;
        for(int i=0;i<words.length;i++){
            if(vowel(words[i])){
                c++;
            }
            hm.put(i, c);
        }
        int n=queries.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            int st=queries[i][0];
            int en=queries[i][1];
            arr[i]=hm.get(en)-hm.get(st-1);
        }
        return arr;
    }
    boolean vowel(String s){
        if(!(s.charAt(0)=='a' || s.charAt(0)=='e' ||s.charAt(0)=='i' || s.charAt(0)=='o'||s.charAt(0)=='u'))return false;
        if(!(s.charAt(s.length()-1)=='a' || s.charAt(s.length()-1)=='e' ||s.charAt(s.length()-1)=='i' || s.charAt(s.length()-1)=='o'||s.charAt(s.length()-1)=='u'))return false;
        return true;
    }
}