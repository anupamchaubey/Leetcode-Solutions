class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = (int) Math.pow(2, k);
        HashSet<String> hs = new HashSet<>();
        
        for (int i = 0; i < s.length() - k + 1; i++) {
            hs.add(s.substring(i, i + k));
        }
        return hs.size()==n;
    }
}