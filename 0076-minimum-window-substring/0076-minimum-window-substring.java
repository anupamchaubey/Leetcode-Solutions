class Solution {
    public String minWindow(String s, String t) {
        int[] arrT = new int[126];
        for (char ch : t.toCharArray()) {
            arrT[ch]--;
        }
        String ans = s + t;
        int cnt = 0;

        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            arrT[s.charAt(i)]++;
            if (arrT[s.charAt(i)] <= 0)
                cnt++;

            while (cnt == t.length()) {
                if (ans.length() > i - l + 1)
                    ans = s.substring(l, i + 1);
                arrT[s.charAt(l)]--;
                if (arrT[s.charAt(l)] < 0)
                    cnt--;
                l++;
            }
        }
        return (ans.length() > s.length()) ? "" : ans;
    }
}