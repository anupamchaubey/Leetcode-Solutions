class Solution {
    // pattern : atmost k distinct elements
    public int totalFruit(int[] fruits) {

        return atmost(fruits, 2);

    }
    int atmost(int[] fruits, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int count = 0;
        int left = 0;
        int max = 0;
        for (int r = 0; r < fruits.length; r++) {
            hm.put(fruits[r], hm.getOrDefault(fruits[r], 0) + 1);

            while (hm.size() > k) {
                hm.put(fruits[left], hm.get(fruits[left]) - 1);
                if (hm.get(fruits[left]) == 0)
                    hm.remove(fruits[left]);
                left++;
            }
            count = r - left + 1;
            max = Math.max(max, count);
        }
        return max;
    }
}