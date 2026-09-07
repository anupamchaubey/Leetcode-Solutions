class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ls = new ArrayList<>();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (target[idx] != i) {
                ls.add("Push");
                ls.add("Pop");
            } else {
                ls.add("Push");
                idx++;
                if (idx == target.length)
                    break;
            }
        }
        return ls;
    }
}