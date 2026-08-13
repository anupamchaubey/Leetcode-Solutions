class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashSet<Character> hs = new HashSet<>();
        for (char ch : s1.toCharArray())
            hs.add(ch);

        for (int i = 0; i < s2.length(); i++) {
            if (hs.contains(s2.charAt(i))) {
                if (equal(s1, s2.substring(i, Math.min(s2.length(), i + s1.length()))))
                    return true;
            }
        }
        return false;
    }

    boolean equal(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a']++;
            arr[b.charAt(i) - 'a']--;
        }
        for (int x : arr)
            if (x != 0)
                return false;
        return true;
    }
}