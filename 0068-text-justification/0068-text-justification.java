class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        int len = 0;
        StringBuilder sb = new StringBuilder();

        List<String> ls = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() <= maxWidth) {
                len += words[i].length() + 1;
                sb.append(words[i] + " ");
            } else {
                ls.add(sb.toString());
                sb.setLength(0);
                len = words[i].length() + 1;
                sb.append(words[i] + " ");
            }
        }
        if (sb.length() > 0) {
            ls.add(sb.toString());
        }
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < ls.size() - 1; i++) {
            String str = ls.get(i);
            String[] arr = str.split(" ");
            sb.setLength(0);

            if (arr.length == 1) {
                sb.append(arr[0]);
                while (sb.length() < maxWidth)
                    sb.append(" ");
            } else {
                int holes = arr.length - 1;
                int sum = 0;
                for (String x : arr)
                    sum += x.length();
                int remaining = maxWidth - sum;
                int div = remaining / holes;
                remaining = remaining - (div * holes);
                for (int idx = 0; idx < arr.length; idx++) {
                    sb.append(arr[idx]);
                    if (idx == arr.length - 1)
                        continue;
                    int p = div;
                    while (p-- > 0) {
                        sb.append(" ");
                    }
                    if (remaining-- > 0)
                        sb.append(" ");
                }
            }
            ans.add(sb.toString());
        }
        String str = ls.get(ls.size() - 1);
        String[] arr = str.split(" ");
        sb.setLength(0);
        for (String s : arr) {
            sb.append(s).append(" ");
        }
        sb = new StringBuilder(sb.toString().trim());
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        ans.add(sb.toString());
        return ans;
    }
}