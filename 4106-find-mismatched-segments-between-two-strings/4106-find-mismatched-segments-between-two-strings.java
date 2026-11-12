class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ls = new ArrayList<>();
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                str1 += s1.charAt(i);
                str2 += s2.charAt(i);
            } else {
                if (str1.equals(""))
                    continue;
                List<String> list = new ArrayList<>();
                list.add(str1);
                list.add(str2);
                ls.add(list);
                str1 = "";
                str2 = "";
            }
        }
        if (!str1.equals("")) {
            List<String> list = new ArrayList<>();
            list.add(str1);
            list.add(str2);
            ls.add(list);
            str1 = "";
            str2 = "";
        }
        return ls;

    }
}