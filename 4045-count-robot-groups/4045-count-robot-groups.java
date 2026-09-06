class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int groups = 0;
        int right = position.length - 1;
        for (int i = position.length - 2; i >= 0; i--) {
            if (position[i + 1] - position[i] <= distance)
                continue;
            if (speed[right] >= speed[i]) {
                groups++;
                right = i;
            }
        }
        return groups+1;
    }
}