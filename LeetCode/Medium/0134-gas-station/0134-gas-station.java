class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalgas = 0;
        int totalcost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalgas += gas[i];
            totalcost += cost[i];
        }
        if (totalgas < totalcost)
            return -1;

        int gases = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            gases += (gas[i] - cost[i]);
            if (gases < 0) {
                gases = 0;
                start = i + 1;
            }
        }
        return start;
    }
}