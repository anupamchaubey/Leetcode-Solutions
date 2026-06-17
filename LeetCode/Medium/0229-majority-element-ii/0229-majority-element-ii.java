class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                c++;
            else {
                if (c > nums.length / 3) {
                    ls.add(nums[i - 1]);
                }
                c = 1;
            }
        }
        if (c > nums.length / 3) {
            ls.add(nums[nums.length - 1]);
        }
        return ls;
    }
}