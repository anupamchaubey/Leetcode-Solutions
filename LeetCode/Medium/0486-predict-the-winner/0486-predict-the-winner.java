class Solution {
    public boolean predictTheWinner(int[] nums) {
        return win(nums, 0, nums.length-1, 0, 0, true);
    }
    boolean win(int[] nums, int l, int r, int score1, int score2, boolean player1){
        if(l>r){
            return score1>=score2;
        }
        if(player1){
            boolean a=win(nums, l+1, r, score1+nums[l], score2, !player1);
            boolean b=win(nums, l, r-1, score1+nums[r], score2, !player1);
            return a||b;
        }else{
            boolean a=win(nums, l+1, r, score1, score2+nums[l], !player1);
            boolean b=win(nums, l, r-1, score1, score2+nums[r], !player1);
            return a&&b;
        }
    }
}