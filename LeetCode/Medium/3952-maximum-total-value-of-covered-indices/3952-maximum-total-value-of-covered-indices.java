class Solution {
    public long maxTotal(int[] nums, String s) {
        if (s.equals(""))
            return 0;
        long ans = 0;
        boolean[] used = new boolean[s.length()];

        if (s.charAt(0) == '1') {
            ans += nums[0];
            used[0] = true;
        }
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                if(used[i-1]){
                    ans+=nums[i];
                    used[i]=true;
                    i++;
                    continue;
                }
                int min = -1;
                while (i < s.length() && s.charAt(i) == '1') {
                    if (min == -1 || nums[i - 1] < nums[min]) {
                        min = i - 1;
                    }
                    used[i-1]=true;
                    ans += nums[i - 1];
                    i++;
                }
                ans += nums[i - 1];
                if (min == -1 || nums[i - 1] < nums[min]) {
                    min = i - 1;
                }
                used[i-1]=true;
                ans -= nums[min];
                used[min]=false;
            }
            i++;
        }
        return ans;
    }
}