class Solution {
    public boolean uniformArray(int[] nums1) {

        //check for all elements odd
        int smallestOddIndex = -1;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 != 0)
                if (smallestOddIndex == -1 || nums1[i] < nums1[smallestOddIndex])
                    smallestOddIndex = i;
        }
        boolean odd = true;
        boolean even = true;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 != 0) {
                if (smallestOddIndex != -1 && nums1[i] - nums1[smallestOddIndex] >= 1)
                    continue;
                else
                    even = false;
            } else {
                if (smallestOddIndex != -1 && nums1[i] - nums1[smallestOddIndex] >= 1)
                    continue;
                else
                    odd = false;
            }
        }
        return odd | even;

    }
}