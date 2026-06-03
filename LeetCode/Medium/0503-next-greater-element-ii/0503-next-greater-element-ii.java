class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Deque<Integer> st = new ArrayDeque<>();
        Deque<Integer> lt = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (lt.isEmpty() || nums[i] > nums[lt.peekFirst()]) {
                lt.addLast(i);
            }
        }
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()])
                st.pop();
            if (st.isEmpty()) {
                while (!lt.isEmpty() && nums[i] >= nums[lt.peekFirst()]) {
                    if (lt.peekFirst() >= i)
                        break;
                    lt.pollFirst();
                }
                if (!lt.isEmpty() && lt.peekFirst() < i) {
                    ans[i] = nums[lt.peekFirst()];
                } else {
                    ans[i] = -1;
                }
            } else
                ans[i] = nums[st.peek()];
            st.push(i);
        }
        return ans;
    }
}