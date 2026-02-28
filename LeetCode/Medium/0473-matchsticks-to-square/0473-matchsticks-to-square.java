class Solution {

    public boolean makesquare(int[] matchsticks) {
        int side = 0;
        for (int i : matchsticks) {
            side += i;
        }
        if (side % 4 != 0)
            return false;
        side /= 4;
        return backtrack(matchsticks, matchsticks.length - 1, 0, 0, 0, 0, side);
    }

    boolean backtrack(int[] matchsticks, int idx, int side1, int side2, int side3, int side4, int side) {
        if (side1 > side || side2 > side || side3 > side || side4 > side) {
            return false;
        }
        if (idx < 0) {
            if (side1 == side && side2 == side && side3 == side && side4 == side) {
                return true;
            }
            return false;
        }
        boolean a = backtrack(matchsticks, idx - 1, side1 + matchsticks[idx], side2, side3, side4, side);
        if (a)
            return true;
        boolean b = backtrack(matchsticks, idx - 1, side1, side2 + matchsticks[idx], side3, side4, side);
        if (b)
            return true;
        boolean c = backtrack(matchsticks, idx - 1, side1, side2, side3 + matchsticks[idx], side4, side);
        if (c)
            return true;
        boolean d = backtrack(matchsticks, idx - 1, side1, side2, side3, side4 + matchsticks[idx], side);
        return a || b || c || d;
    }
}
