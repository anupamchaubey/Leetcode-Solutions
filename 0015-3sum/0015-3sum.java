class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;

        while (i < nums.length - 2) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;

                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }

            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1])
                i++;
        }
        return ans;
    }
}