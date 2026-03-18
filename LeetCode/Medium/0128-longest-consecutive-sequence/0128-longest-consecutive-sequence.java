class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int x:nums)hs.add(x);
        int c=0;
        for(int x: nums){
            
            if(!hs.contains(x-1)){
                int cnt=1;
                while(hs.contains(x+1)){
                    cnt++;
                    x=x+1;
                }
                c=Math.max(c, cnt);
            }
            
        }
        return c;
    }
}