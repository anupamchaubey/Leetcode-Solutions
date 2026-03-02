class Solution {
    public int minSteps(int n) {
        if(n==1)return 0;
        return rec(n, 1, 1)+1;
    }
    int rec(int n, int letters, int copied){
        if(letters==n)return 0;
        if(letters>n)return Integer.MAX_VALUE/3;
        int min=Integer.MAX_VALUE;
        min=Math.min(min, 1+rec(n, letters+copied, copied));
        min=Math.min(min, 2+rec(n, letters+letters, letters));
        return min;
    }
}