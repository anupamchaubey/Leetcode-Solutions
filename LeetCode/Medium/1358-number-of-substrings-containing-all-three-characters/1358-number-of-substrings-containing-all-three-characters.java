class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        HashMap<Character, Integer> hm=new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), i);

            if (hm.containsKey('a') && hm.containsKey('b') && hm.containsKey('c')){
                int min=Math.min(hm.get('a'), Math.min(hm.get('b'), hm.get('c')));
                count+=min+1;
            }
                    
        }
        return count;
    }
}