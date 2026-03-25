class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE/2;
        int maxProfit=0;
        for(int x:prices){
            maxProfit=Math.max(maxProfit, x-min);
            min=Math.min(x, min);
        }
        return maxProfit;
    }
}