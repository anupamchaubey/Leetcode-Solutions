class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,totalcost=0;
        int totalgas=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i];
            totalcost+=cost[i];
            totalgas+=gas[i];
            if(totalgas<cost[i]){
                start=i+1;
                totalgas=0;
            }else{
                totalgas-=cost[i];
            }
        }
        if(total<totalcost)return -1;
        return start;
    }
}