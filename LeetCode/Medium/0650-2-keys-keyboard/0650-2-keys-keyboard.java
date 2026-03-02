class Solution {
    public int minSteps(int n) {
        if(n==1)return 0;
        return rec(n, 1, 1)+1;
    }
    int rec(int n, int cnt, int paste){
        if(cnt==n)return 0;
        if(cnt>n)return Integer.MAX_VALUE/3;
        int min=Integer.MAX_VALUE;
        //paste
        min=Math.min(min, 1+rec(n, cnt+paste, paste));
        //copy all + paste
        min=Math.min(min, 2+rec(n, cnt+cnt, cnt));
        return min;
    }
}