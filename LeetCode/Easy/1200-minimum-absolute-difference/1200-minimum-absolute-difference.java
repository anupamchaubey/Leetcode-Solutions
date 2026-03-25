class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int k = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < k)
                k = arr[i] - arr[i - 1];
        }

        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - arr[i - 1] == k) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[i - 1]);
                l.add(arr[i]);
                ls.add(l);
            }

        }
        return ls;
    }
}