class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int x : nums) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        List<Integer> ls = new ArrayList<>();
        for (int x : hm.keySet()) {
            ls.add(x);
        }
        Collections.sort(ls, (a, b) -> hm.get(b) - hm.get(a));
        int[] arr = new int[k];
        int i = 0;
        arr[i++] = ls.get(0);
        k -= 1;
        for (int p = 1; p < ls.size() && k > 0; p++) {
            if (ls.get(p) != ls.get(p - 1)) {
                arr[i++] = ls.get(p);
                k--;
            }
        }
        return arr;
    }
}