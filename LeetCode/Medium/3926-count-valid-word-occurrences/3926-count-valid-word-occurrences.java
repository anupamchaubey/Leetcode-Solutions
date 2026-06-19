class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        HashMap<String, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (String s : chunks) {
            for (char ch : s.toCharArray()) {
                if ((ch == ' ' || ch == '-') && sb.length() == 0)
                    continue;
                if (ch == ' ') {
                    String str = sb.toString().trim();
                    if (str.charAt(str.length() - 1) == '-')
                        str = str.substring(0, str.length() - 1);
                    hm.put(str, hm.getOrDefault(str, 0) + 1);
                    sb.setLength(0);
                } else if (ch == '-' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
                    String str = sb.toString().substring(0, sb.length() - 1).trim();
                    hm.put(str, hm.getOrDefault(str, 0) + 1);
                    sb.setLength(0);
                } else {
                    sb.append(ch);
                }
            }
        }
        if (sb.length() > 0) {
            String str = sb.toString().trim();
            if (str.charAt(str.length() - 1) == '-')
                str = str.substring(0, str.length() - 1);
            hm.put(str, hm.getOrDefault(str, 0) + 1);
            sb.setLength(0);
        }

        // for (String s : hm.keySet()) {
        //     System.out.println(s + "  ->  " + hm.getOrDefault(s, 0));
        // }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            ans[i] = hm.getOrDefault(s, 0);
        }
        return ans;
    }
}