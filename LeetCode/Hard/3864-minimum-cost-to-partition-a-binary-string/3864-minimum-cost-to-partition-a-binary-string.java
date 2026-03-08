class Solution {

    public long minCost(String s, int enc, int flat) {
        return rec(s, 0, s.length() - 1, enc, flat);
    }

    long rec(String s, int st, int en, int enc, int flat) {
        if(st>=en)return s.charAt(st)=='1'? enc: flat;
        int len=en-st+1;
        int count=sen(s, st, en);
        long store;
        if(count==0)store=flat;
        else store=len*count*enc;

        if(len%2==0){
            int mid=(en+st)/2;
            long left=rec(s, st, mid, enc, flat);
            long right=rec(s, mid+1, en, enc, flat);
            return Math.min(store, left+right);
        }
        return store;
    }

    int sen(String s, int i, int j) {
        int c = 0;

        for (int k = i; k <= j; k++) {
            if (s.charAt(k) == '1')
                c++;
        }

        return c;
    }
}