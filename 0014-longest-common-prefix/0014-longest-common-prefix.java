class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for (String str : strs) {
            if (str.length() < common.length())
                common = str;
        }
        for (String s : strs) {
            if (s.startsWith(common))
                continue;
            int l = 0, r = common.length() - 1;
            int idx = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (s.startsWith(common.substring(0, mid + 1))) {
                    idx = mid;
                    l = mid + 1;
                } else
                    r = mid - 1;
            }
            common = common.substring(0, idx + 1);
        }
        return common;
    }
}