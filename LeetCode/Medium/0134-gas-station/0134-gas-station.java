class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalcostneeded = 0;
        int totalgas = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            totalgas += gas[i];
            totalcostneeded += cost[i];
        }
        if (totalcostneeded > totalgas)
            return -1;

        int fueltillhere = 0;
        int startindex = 0;
        for (int i = 0; i < n; i++) {
            fueltillhere += (gas[i] - cost[i]);
            if (fueltillhere < 0) {
                fueltillhere = 0;
                startindex = i + 1;
            }
        }
        return startindex;
    }
}