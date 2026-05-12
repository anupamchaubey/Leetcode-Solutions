class Solution {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int previousStair=2;
        int previousSecondStair=1;
        int totalStepsTillHere=0;
        for(int i=3;i<=n;i++){
            totalStepsTillHere=previousStair+previousSecondStair;
            previousSecondStair=previousStair;
            previousStair=totalStepsTillHere;
        }
        return totalStepsTillHere;
    }
}