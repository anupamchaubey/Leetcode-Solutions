class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hm = new HashMap<>();
        for (List<String> ls : knowledge) {
            hm.put(ls.get(0), ls.get(1));
        }
        String[] arr = s.split("\\)");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {

            int idx = arr[i].indexOf("(");
            if (idx == -1) {
                sb.append(arr[i]);
                continue;
            }
            String key = arr[i].substring(idx + 1, arr[i].length());

            if (hm.containsKey(key)) {
                sb.append(arr[i].substring(0, idx)).append(hm.get(key));
            } else {
                sb.append(arr[i].substring(0, idx)).append("?");
            }
        }
        return sb.toString();
    }
}