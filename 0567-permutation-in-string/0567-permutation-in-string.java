class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[200];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)]--;
        }
        int len = 0;
        int l = 0;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            arr[ch]++;
            if (arr[ch] <= 0)
                len++;
            if (len == s1.length())
                return true;
            while (i - l + 1 >= s1.length()) {
                if (arr[s2.charAt(l)] <= 0)
                    len--;
                arr[s2.charAt(l)]--;
                l++;
            }
        }
        return false;
    }
}