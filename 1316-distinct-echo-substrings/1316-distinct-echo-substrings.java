class Solution {
    public int distinctEchoSubstrings(String text) {
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                String s = text.substring(i, j + 1);
                if (j + s.length() < text.length() && text.substring(j + 1, j + s.length() + 1).equals(s))
                    hs.add(s);
            }
        }
        return hs.size();
    }
}