class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            char a = Character.toLowerCase(s.charAt(i));
            char b = Character.toLowerCase(s.charAt(j));
            if (a != b)
                return false;
            i++;
            j--;
        }
        return true;
    }
}