class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = (int) Math.pow(2, k);
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++)
            hs.add(i);
        for (int i = 0; i < s.length() - k + 1; i++) {
            int x = Integer.parseInt(s.substring(i, i + k), 2);
            if (hs.contains(x))
                hs.remove(x);
        }
        return hs.isEmpty();
    }
}