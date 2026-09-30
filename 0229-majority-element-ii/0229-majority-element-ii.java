class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        int freq1 = 0;
        int num1 = 0;
        int freq2 = 0;
        int num2 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (freq1 == 0 && nums[i] != num2) {
                num1 = nums[i];
                freq1 += 1;
            } else if (freq2 == 0 && nums[i] != num1) {
                num2 = nums[i];
                freq2 += 1;
            } else if (num1 == nums[i]) {
                freq1++;
            } else if (num2 == nums[i]) {
                freq2++;
            } else {
                freq1--;
                freq2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int x : nums) {
            if (x == num1)
                cnt1++;
            if (x == num2)
                cnt2++;
        }
        if (cnt1 > n / 3)
            ls.add(num1);
        if (cnt2 > n / 3)
            ls.add(num2);
        return ls;
    }
}