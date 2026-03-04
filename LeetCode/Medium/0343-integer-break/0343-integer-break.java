class Solution {
/*

 n=3∗k+r where r=0,2,4
A pow solution is possible.

*/
// maximum jitna 3 hoga utni bdi value

    public int integerBreak(int n) {
        
        if (n == 2)
            return 1;
        int ans = 1;
        while (n > 0) {
            if (n == 2 || n == 4) {
                ans *= n;
                break;
            }
            ans *= 3;
            n -= 3;
        }
        return ans;
    }
}