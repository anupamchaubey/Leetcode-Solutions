class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls= new ArrayList<>();
        
        for(int i=0;i<s.length()-p.length()+1;i++){
            char[] str=s.substring(i, p.length()+i).toCharArray();
            Arrays.sort(str);
            String st=new String(str);
            if(st.equals(p)){
                ls.add(i);
            }
        }
        return ls;
    }
}