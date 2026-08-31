class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        if ((source[0] + source[1]) % 2 != (target[0] + target[1]) % 2)
            return -1;
        int x = source[0];
        int y = source[1];
        int a = target[0];
        int b = target[1];
        if (Math.abs(a - x) != Math.abs(b - y))
            return 2;
        return 1;
    }
}