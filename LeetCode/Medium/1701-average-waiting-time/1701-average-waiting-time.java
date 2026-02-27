class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n=customers.length;
        double wait_sum=0;
        int curr_time=0;

        for(int i=0;i<n;i++){
            int t=customers[i][0];
            int c=customers[i][1];
            if(t<curr_time){
                wait_sum+=curr_time-t;
            }
            curr_time=Math.max(curr_time, t);
            
            wait_sum+=c;
            curr_time+=c;

        }
        return wait_sum/n;
    }
}