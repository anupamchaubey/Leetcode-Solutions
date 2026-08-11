class Solution {
    public int minOperations(String s1, String s2) {
        if (s1.length() == 1) {
            if (s1.charAt(0) != s2.charAt(0)) {
                if (s1.charAt(0) == '1')
                    return -1;
                return 1;
            }
            return 0;
        }
        int op = 0;
        int n = s1.length();
        char[] arr = s1.toCharArray();

        int i = 0;
        while (i < s1.length()) {
            if (arr[i] != s2.charAt(i)) {
                if (arr[i] == '0') {
                    op += 1;
                    arr[i] = '1';
                } else {
                    if (i + 1 < s1.length() && arr[i + 1] == '1') {
                        op += 1;
                        arr[i + 1] = '0';
                        arr[i] = '0';
                    } else {
                        op += 2;
                        arr[i] = '0';
                    }
                }
            }
            i++;
        }

        return op;
    }
}